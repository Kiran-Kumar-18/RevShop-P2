package com.rev.app.mapper;

import com.rev.app.dto.OrderResponseDTO;
import com.rev.app.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final OrderItemMapper orderItemMapper;
    private final AddressMapper addressMapper;

    public OrderMapper(OrderItemMapper orderItemMapper, AddressMapper addressMapper) {
        this.orderItemMapper = orderItemMapper;
        this.addressMapper = addressMapper;
    }

    public OrderResponseDTO toDto(Order entity) {
        if (entity == null) {
            return null;
        }

        return OrderResponseDTO.builder()
                .orderId(entity.getOrderId())
                .userId(entity.getUser() != null ? entity.getUser().getUserId() : null)
                .orderDate(entity.getOrderDate())
                .totalAmount(entity.getTotalAmount())
                .status(entity.getStatus())
                .userName(entity.getUser() != null ? entity.getUser().getName() : null)
                .shippingAddress(addressMapper.toDto(entity.getShippingAddress()))
                .billingAddress(addressMapper.toDto(entity.getBillingAddress()))
                .statusUpdatedAt(entity.getStatusUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();
    }

    public OrderResponseDTO toDto(Order entity, java.util.List<com.rev.app.entity.OrderItem> items) {
        OrderResponseDTO dto = toDto(entity);
        if (dto != null && items != null) {
            dto.setItems(items.stream()
                    .map(orderItemMapper::toDto)
                    .collect(java.util.stream.Collectors.toList()));
        }
        return dto;
    }
}

