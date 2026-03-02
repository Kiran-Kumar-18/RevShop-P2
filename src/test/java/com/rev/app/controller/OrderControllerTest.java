package com.rev.app.controller;

import com.rev.app.entity.Order;
import com.rev.app.dto.OrderResponseDTO;
import com.rev.app.mapper.OrderMapper;
import com.rev.app.service.IOrderService;
import com.rev.app.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IOrderService orderService;

    @Mock
    private OrderMapper orderMapper;

    @Mock
    private IUserService userService;

    @InjectMocks
    private OrderController orderController;

    private Order order;
    private OrderResponseDTO orderResponseDTO;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        order = new Order();
        order.setOrderId(1);
        order.setStatus("PENDING");
        order.setTotalAmount(new BigDecimal("500.00"));

        orderResponseDTO = OrderResponseDTO.builder()
                .orderId(1)
                .status("PENDING")
                .totalAmount(new BigDecimal("500.00"))
                .build();
    }

    @Test
    public void givenOrderId_whenGetOrderById_thenReturnOrder() throws Exception {
        when(orderService.getOrderById(anyInt())).thenReturn(order);
        when(orderService.getOrderItems(anyInt())).thenReturn(Collections.emptyList());
        when(orderMapper.toDto(any(Order.class), any())).thenReturn(orderResponseDTO);

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.orderId").value(1));
    }

    @Test
    public void whenGetStatuses_thenReturnList() throws Exception {
        when(orderService.getOrderStatuses()).thenReturn(Collections.singletonList("PENDING"));

        mockMvc.perform(get("/api/orders/statuses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]").value("PENDING"));
    }
}
