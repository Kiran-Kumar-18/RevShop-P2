package com.rev.app.mapper;

import com.rev.app.dto.OrderItemResponseDTO;
import com.rev.app.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemResponseDTO toDto(OrderItem entity) {
        if (entity == null) {
            return null;
        }

        return OrderItemResponseDTO.builder()
                .orderItemId(entity.getOrderItemId())
                .productId(entity.getProduct() != null ? entity.getProduct().getProductId() : null)
                .productName(entity.getProduct() != null ? entity.getProduct().getName() : null)
                .productImageUrl(entity.getProduct() != null ? entity.getProduct().getImageUrl() : null)
                .quantity(entity.getQuantity())
                .unitPrice(entity.getUnitPrice())
                .subtotal(entity.getSubtotal())
                .build();
    }
}
