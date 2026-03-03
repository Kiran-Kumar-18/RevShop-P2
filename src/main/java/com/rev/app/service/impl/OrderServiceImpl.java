package com.rev.app.service.impl;

import com.rev.app.dto.OrderRequestDTO;
import com.rev.app.entity.*;
import com.rev.app.repository.*;
import com.rev.app.service.INotificationService;
import com.rev.app.service.IOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private final IOrderRepository iorderRepository;
    private final IOrderItemRepository iorderItemRepository;
    private final ICartRepository icartRepository;
    private final ICartItemRepository icartItemRepository;
    private final IProductRepository iproductRepository;
    private final IUserRepository iuserRepository;
    private final IAddressRepository iaddressRepository;
    private final INotificationService inotificationService;
    private final IOrderStatusHistoryRepository iorderStatusHistoryRepository;
    private final ISellerRepository isellerRepository;
    private final IPaymentRepository ipaymentRepository;

    @Override
    @Transactional
    public Order placeOrder(OrderRequestDTO request) {
        if (request.getUserId() == null) {
            logger.error("Order placement failed: User ID is null");
            throw new com.rev.app.exception.BadRequestException("User ID must not be null");
        }
        if (request.getShippingAddressId() == null) {
            throw new com.rev.app.exception.BadRequestException("Shipping address ID must not be null");
        }
        if (request.getBillingAddressId() == null) {
            throw new com.rev.app.exception.BadRequestException("Billing address ID must not be null");
        }

        User user = iuserRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        if ("ROLE_SELLER".equals(user.getRole())) {
            throw new RuntimeException("Sellers are not allowed to place orders");
        }
        Cart cart = icartRepository.findByUserUserId(user.getUserId()).orElseThrow(() -> new RuntimeException("Cart is empty"));
        List<CartItem> cartItems = icartItemRepository.findByCartCartId(cart.getCartId());
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cannot place order with empty cart");
        }
        Address shippingAddress = iaddressRepository.findById(request.getShippingAddressId()).orElseThrow(() -> new RuntimeException("Shipping address not found"));
        Address billingAddress = iaddressRepository.findById(request.getBillingAddressId()).orElseThrow(() -> new RuntimeException("Billing address not found"));
        BigDecimal totalAmount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            
            BigDecimal originalPrice = product.getPrice() != null ? product.getPrice() : BigDecimal.ZERO;
            BigDecimal unitDiscount = product.getDiscountPrice() != null ? product.getDiscountPrice() : BigDecimal.ZERO;
            BigDecimal finalUnitPrice = originalPrice.subtract(unitDiscount).setScale(2, RoundingMode.HALF_UP);
            
            totalAmount = totalAmount.add(finalUnitPrice.multiply(new BigDecimal(item.getQuantity())).setScale(2, RoundingMode.HALF_UP));
        }
        Order order = Order.builder().user(user).shippingAddress(shippingAddress).billingAddress(billingAddress).totalAmount(totalAmount).status("PENDING").build();
        order = iorderRepository.save(order);
        logger.info("Order placed successfully. Order ID: {}, User: {}, Total: {}", order.getOrderId(), user.getEmail(), totalAmount);
        java.util.Set<User> sellersToNotify = new java.util.HashSet<>();
        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            int newStock = (product.getStockQuantity() != null ? product.getStockQuantity() : 0) - item.getQuantity();
            product.setStockQuantity(newStock);
            iproductRepository.save(product);

            // Low Stock Alert logic
            if (product.getSeller() != null && product.getSeller().getUser() != null &&
                product.getStockThreshold() != null && newStock <= product.getStockThreshold()) {
                inotificationService.createNotification(product.getSeller().getUser(),
                    "Low Stock Alert", "Product '" + product.getName() + "' is below threshold (" + newStock + " left)", "STOCK");
            }

            BigDecimal originalPrice = product.getPrice() != null ? product.getPrice() : BigDecimal.ZERO;
            BigDecimal unitDiscount = product.getDiscountPrice() != null ? product.getDiscountPrice() : BigDecimal.ZERO;
            BigDecimal finalUnitPrice = originalPrice.subtract(unitDiscount).setScale(2, RoundingMode.HALF_UP);
            BigDecimal subtotal = finalUnitPrice.multiply(new BigDecimal(item.getQuantity())).setScale(2, RoundingMode.HALF_UP);
            
            OrderItem orderItem = OrderItem.builder()
                .order(order)
                .product(product)
                .seller(product.getSeller())
                .unitPrice(finalUnitPrice)
                .quantity(item.getQuantity())
                .subtotal(subtotal)
                .build();
            iorderItemRepository.save(orderItem);
            if (product.getSeller() != null && product.getSeller().getUser() != null) {
                sellersToNotify.add(product.getSeller().getUser());
            }
        }
        icartItemRepository.deleteAll(cartItems);

        for (User sellerUser : sellersToNotify) {
            inotificationService.createNotification(sellerUser, "New Order Received", "You have a new order: #" + order.getOrderId(), "ORDER");
        }

        // Save initial status history
        iorderStatusHistoryRepository.save(OrderStatusHistory.builder()
                .order(order)
                .status("PENDING")
                .updatedBy("SYSTEM")
                .remarks("Order placed by customer")
                .build());

        // Handle Payment record for COD
        if ("COD".equalsIgnoreCase(request.getPaymentMethod())) {
            Payment codPayment = Payment.builder()
                .order(order)
                .method("COD")
                .amount(totalAmount)
                .paymentStatus("PENDING")
                .build();
            ipaymentRepository.save(codPayment);
        }

        return order;
    }

    @Override
    public Order getOrderById(Integer id) {
        return iorderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Page<Order> getUserOrders(Integer userId, Pageable pageable) {
        return iorderRepository.findByUserUserId(userId, pageable);
    }

    @Override
    public Page<Order> getSellerOrders(Integer sellerUserId, Pageable pageable) {
        return iorderRepository.findOrdersBySellerUserId(sellerUserId, pageable);
    }

    @Override
    @Transactional
    public Order updateOrderStatus(Integer orderId, String status, Integer userId) {
        Order order = iorderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        User updatingUser = iuserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Authorization check
        String role = updatingUser.getRole() != null ? updatingUser.getRole().toUpperCase() : "";
        if ("ROLE_SELLER".equals(role)) {
            // Check if this seller has any items in this order
            boolean isAssignedSeller = iorderItemRepository.findByOrderOrderId(orderId).stream()
                .anyMatch(item -> item.getSeller() != null && 
                                  item.getSeller().getUser() != null && 
                                  item.getSeller().getUser().getUserId().equals(userId));
            if (!isAssignedSeller) {
                throw new RuntimeException("You are not authorized to update this order");
            }
        } else if ("ROLE_BUYER".equals(role)) {
            // Allow buyers to cancel or return their own orders
            if (!List.of("RETURNED", "CANCELLED").contains(status.toUpperCase())) {
                throw new RuntimeException("User does not have permission to update order status to " + status);
            }
            if (!order.getUser().getUserId().equals(userId)) {
                throw new RuntimeException("You are not authorized to update this order");
            }
        } else if (!"ROLE_ADMIN".equals(role)) {
            throw new RuntimeException("User does not have permission to update order status");
        }

        // Transition validation
        String currentStatus = order.getStatus() != null ? order.getStatus().toUpperCase() : "PENDING";
        String targetStatus = status.toUpperCase();

        if (isInvalidTransition(currentStatus, targetStatus)) {
            throw new RuntimeException("Invalid status transition from " + currentStatus + " to " + targetStatus);
        }

        order.setStatus(targetStatus);
        order.setStatusUpdatedAt(java.time.LocalDateTime.now());
        order.setUpdatedBy(updatingUser.getRole().replace("ROLE_", ""));
        order = iorderRepository.save(order);
        logger.info("Order ID: {} status updated from {} to {} by {} ({})", orderId, currentStatus, targetStatus, updatingUser.getEmail(), updatingUser.getRole());

        boolean isCod = ipaymentRepository.findByOrderOrderId(orderId)
                .map(p -> "COD".equalsIgnoreCase(p.getMethod()))
                .orElse(false);

        // Add Revenue for COD on Shipped or Delivered
        if (isCod && ("SHIPPED".equals(targetStatus) || "DELIVERED".equals(targetStatus))) {
            // Avoid duplicate additions if already shipped/delivered
            if (!"SHIPPED".equals(currentStatus) && !"DELIVERED".equals(currentStatus)) {
                List<OrderItem> items = iorderItemRepository.findByOrderOrderId(orderId);
                for (OrderItem item : items) {
                    Seller seller = item.getSeller();
                    if (seller != null) {
                        BigDecimal currentRev = seller.getTotalRevenue() != null ? seller.getTotalRevenue() : BigDecimal.ZERO;
                        seller.setTotalRevenue(currentRev.add(item.getSubtotal()));
                        isellerRepository.save(seller);
                        logger.debug("Added revenue {} to seller {} for order item in order #{}", item.getSubtotal(), seller.getBusinessName(), orderId);
                    }
                }
            }
        }

        // Deduct revenue if cancelled, returned, or put on hold (COD only for hold)
        if (!targetStatus.equals(currentStatus)) {
            boolean shouldDeduct = false;
            
            if (isCod) {
                // For COD, deduct if moving away from Shipped/Delivered to Cancelled, Returned, or Pending (Hold)
                List<String> targetStatesThatDeduct = List.of("CANCELLED", "RETURNED", "PENDING");
                shouldDeduct = targetStatesThatDeduct.contains(targetStatus) && 
                               List.of("SHIPPED", "DELIVERED").contains(currentStatus);
            } else {
                // For Online, only deduct if actually cancelled or returned
                List<String> targetStatesThatDeduct = List.of("CANCELLED", "RETURNED");
                shouldDeduct = targetStatesThatDeduct.contains(targetStatus) && 
                               List.of("PAID", "PROCESSING", "SHIPPED", "DELIVERED").contains(currentStatus);
            }

            if (shouldDeduct) {
                List<OrderItem> items = iorderItemRepository.findByOrderOrderId(orderId);
                for (OrderItem item : items) {
                    Seller seller = item.getSeller();
                    if (seller != null) {
                        BigDecimal subtotal = item.getSubtotal();
                        BigDecimal currentRev = seller.getTotalRevenue() != null ? seller.getTotalRevenue() : BigDecimal.ZERO;
                        seller.setTotalRevenue(currentRev.subtract(subtotal));
                        isellerRepository.save(seller);
                        logger.debug("Deducted revenue {} from seller {} for {} order #{}", subtotal, seller.getBusinessName(), targetStatus.toLowerCase(), orderId);
                    }
                }
            }
        }
        
        // Save status history
        iorderStatusHistoryRepository.save(OrderStatusHistory.builder()
                .order(order)
                .status(targetStatus)
                .updatedBy(updatingUser.getRole().replace("ROLE_", ""))
                .remarks("Status updated by " + updatingUser.getRole().replace("ROLE_", "").toLowerCase())
                .build());

        inotificationService.createNotification(order.getUser(), "Order Update", "Your order #" + orderId + " is now " + targetStatus, "ORDER");
        
        return order;
    }

    private boolean isInvalidTransition(String current, String target) {
        if (current.equals(target)) return false;
        
        if (current.equals("DELIVERED") && target.equals("RETURNED")) {
            return false; // Allowed transition
        }

        if (List.of("DELIVERED", "CANCELLED", "REJECTED", "RETURNED").contains(current)) {
            return true; // Cannot move out of terminal states
        }

        if (target.equals("PENDING")) {
            return false; // Allowed "Hold" state
        }

        if (current.equals("SHIPPED") && target.equals("PROCESSING")) {
            return true; // Still block going back to Processing from Shipped
        }

        return false;
    }

    @Override
    public List<OrderStatusHistory> getOrderHistory(Integer orderId) {
        return iorderStatusHistoryRepository.findByOrderOrderIdOrderByUpdatedAtDesc(orderId);
    }

    @Override
    public List<String> getOrderStatuses() {
        return List.of("PENDING", "PROCESSING", "SHIPPED", "DELIVERED", "CANCELLED", "REJECTED", "RETURNED");
    }

    @Override
    public List<OrderItem> getOrderItems(Integer orderId) {
        return iorderItemRepository.findByOrderOrderId(orderId);
    }

    @java.lang.SuppressWarnings("all")
    
    public OrderServiceImpl(final IOrderRepository iorderRepository, final IOrderItemRepository iorderItemRepository, final ICartRepository icartRepository, final ICartItemRepository icartItemRepository, final IProductRepository iproductRepository, final IUserRepository iuserRepository, final IAddressRepository iaddressRepository, final INotificationService inotificationService, final IOrderStatusHistoryRepository iorderStatusHistoryRepository, final ISellerRepository isellerRepository, final IPaymentRepository ipaymentRepository) {
        this.iorderRepository = iorderRepository;
        this.iorderItemRepository = iorderItemRepository;
        this.icartRepository = icartRepository;
        this.icartItemRepository = icartItemRepository;
        this.iproductRepository = iproductRepository;
        this.iuserRepository = iuserRepository;
        this.iaddressRepository = iaddressRepository;
        this.inotificationService = inotificationService;
        this.iorderStatusHistoryRepository = iorderStatusHistoryRepository;
        this.isellerRepository = isellerRepository;
        this.ipaymentRepository = ipaymentRepository;
    }
}
