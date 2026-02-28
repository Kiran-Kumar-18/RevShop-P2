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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private final IOrderRepository iorderRepository;
    private final IOrderItemRepository iorderItemRepository;
    private final ICartRepository icartRepository;
    private final ICartItemRepository icartItemRepository;
    private final IProductRepository iproductRepository;
    private final IUserRepository iuserRepository;
    private final IAddressRepository iaddressRepository;
    private final INotificationService inotificationService;
    private final IOrderStatusHistoryRepository iorderStatusHistoryRepository;

    @Override
    @Transactional
    public Order placeOrder(OrderRequestDTO request) {
        if (request.getUserId() == null) {
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
        if ("ROLE_SELLER".equals(updatingUser.getRole())) {
            // Check if this seller has any items in this order
            boolean isAssignedSeller = iorderItemRepository.findByOrderOrderId(orderId).stream()
                .anyMatch(item -> item.getSeller().getUser().getUserId().equals(userId));
            if (!isAssignedSeller) {
                throw new RuntimeException("You are not authorized to update this order");
            }
        } else if (!"ROLE_ADMIN".equals(updatingUser.getRole())) {
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
        
        if (List.of("DELIVERED", "CANCELLED", "REJECTED").contains(current)) {
            return true; // Cannot move out of terminal states
        }

        if (current.equals("SHIPPED") && List.of("PENDING", "PROCESSING").contains(target)) {
            return true; // Cannot go back from Shipped
        }

        if (current.equals("PROCESSING") && target.equals("PENDING")) {
            return true; // Cannot go back from Processing
        }

        return false;
    }

    @Override
    public List<OrderStatusHistory> getOrderHistory(Integer orderId) {
        return iorderStatusHistoryRepository.findByOrderOrderIdOrderByUpdatedAtDesc(orderId);
    }

    @Override
    public List<String> getOrderStatuses() {
        return List.of("PENDING", "PROCESSING", "SHIPPED", "DELIVERED", "CANCELLED", "REJECTED");
    }

    @Override
    public List<OrderItem> getOrderItems(Integer orderId) {
        return iorderItemRepository.findByOrderOrderId(orderId);
    }

    @java.lang.SuppressWarnings("all")
    
    public OrderServiceImpl(final IOrderRepository iorderRepository, final IOrderItemRepository iorderItemRepository, final ICartRepository icartRepository, final ICartItemRepository icartItemRepository, final IProductRepository iproductRepository, final IUserRepository iuserRepository, final IAddressRepository iaddressRepository, final INotificationService inotificationService, final IOrderStatusHistoryRepository iorderStatusHistoryRepository) {
        this.iorderRepository = iorderRepository;
        this.iorderItemRepository = iorderItemRepository;
        this.icartRepository = icartRepository;
        this.icartItemRepository = icartItemRepository;
        this.iproductRepository = iproductRepository;
        this.iuserRepository = iuserRepository;
        this.iaddressRepository = iaddressRepository;
        this.inotificationService = inotificationService;
        this.iorderStatusHistoryRepository = iorderStatusHistoryRepository;
    }
}
