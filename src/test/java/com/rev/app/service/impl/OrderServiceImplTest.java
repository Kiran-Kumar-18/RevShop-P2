package com.rev.app.service.impl;

import com.rev.app.dto.OrderRequestDTO;
import com.rev.app.entity.*;
import com.rev.app.repository.*;
import com.rev.app.service.INotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    private IOrderRepository orderRepository;
    @Mock
    private IOrderItemRepository orderItemRepository;
    @Mock
    private ICartRepository cartRepository;
    @Mock
    private ICartItemRepository cartItemRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IAddressRepository addressRepository;
    @Mock
    private INotificationService notificationService;
    @Mock
    private IOrderStatusHistoryRepository orderStatusHistoryRepository;
    @Mock
    private ISellerRepository sellerRepository;
    @Mock
    private IPaymentRepository paymentRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private User buyer;
    private User sellerUser;
    private Seller seller;
    private Product product;
    private Cart cart;
    private Address address;
    private OrderRequestDTO orderRequest;

    @BeforeEach
    void setUp() {
        buyer = new User();
        buyer.setUserId(1);
        buyer.setRole("ROLE_USER");

        sellerUser = new User();
        sellerUser.setUserId(2);
        sellerUser.setRole("ROLE_SELLER");

        seller = new Seller();
        seller.setSellerId(1);
        seller.setUser(sellerUser);

        product = Product.builder()
                .productId(1)
                .name("Test Product")
                .price(new BigDecimal("100.00"))
                .discountPrice(new BigDecimal("10.00"))
                .stockQuantity(10)
                .seller(seller)
                .build();

        cart = new Cart();
        cart.setCartId(1);

        address = new Address();
        address.setAddressId(1);

        orderRequest = OrderRequestDTO.builder()
                .userId(1)
                .shippingAddressId(1)
                .billingAddressId(1)
                .paymentMethod("CREDIT_CARD")
                .build();
    }

    @Test
    void placeOrder_Success() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(CartItem.builder().product(product).quantity(2).build());

        when(userRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(cartRepository.findByUserUserId(1)).thenReturn(Optional.of(cart));
        when(cartItemRepository.findByCartCartId(1)).thenReturn(cartItems);
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        
        Order order = Order.builder().orderId(1).status("PENDING").build();
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.placeOrder(orderRequest);

        assertNotNull(result);
        assertEquals("PENDING", result.getStatus());
        verify(productRepository, times(1)).save(any(Product.class));
        verify(cartItemRepository, times(1)).deleteAll(cartItems);
        verify(notificationService, atLeastOnce()).createNotification(any(), any(), any(), any());
    }

    @Test
    void placeOrder_InsufficientStock() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(CartItem.builder().product(product).quantity(20).build()); // Stock is 10

        when(userRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(cartRepository.findByUserUserId(1)).thenReturn(Optional.of(cart));
        when(cartItemRepository.findByCartCartId(1)).thenReturn(cartItems);
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));

        assertThrows(RuntimeException.class, () -> orderService.placeOrder(orderRequest));
    }

    @Test
    void placeOrder_SellerAttempt() {
        buyer.setRole("ROLE_SELLER");
        when(userRepository.findById(1)).thenReturn(Optional.of(buyer));

        assertThrows(RuntimeException.class, () -> orderService.placeOrder(orderRequest));
    }

    @Test
    void updateOrderStatus_Success() {
        Order order = Order.builder().orderId(1).status("PENDING").build();
        OrderItem item = OrderItem.builder().seller(seller).build();
        
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));
        when(userRepository.findById(2)).thenReturn(Optional.of(sellerUser));
        when(orderItemRepository.findByOrderOrderId(1)).thenReturn(List.of(item));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(paymentRepository.findByOrderOrderId(1)).thenReturn(Optional.empty());

        Order result = orderService.updateOrderStatus(1, "SHIPPED", 2);

        assertEquals("SHIPPED", result.getStatus());
        verify(orderStatusHistoryRepository, times(1)).save(any(OrderStatusHistory.class));
    }

    @Test
    void updateOrderStatus_InvalidTransition() {
        Order order = Order.builder().orderId(1).status("DELIVERED").build();
        
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));
        when(userRepository.findById(2)).thenReturn(Optional.of(sellerUser));
        when(orderItemRepository.findByOrderOrderId(1)).thenReturn(List.of(OrderItem.builder().seller(seller).build()));

        assertThrows(RuntimeException.class, () -> orderService.updateOrderStatus(1, "PENDING", 2));
    }
}
