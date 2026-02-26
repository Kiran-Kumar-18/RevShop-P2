package com.rev.app.mapper;

import com.rev.app.dto.CartItemResponseDTO;
import com.rev.app.dto.CartResponseDTO;
import com.rev.app.entity.Cart;
import com.rev.app.entity.CartItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartItemResponseDTO toDto(CartItem entity) {
        if (entity == null) {
            return null;
        }

        BigDecimal unitPrice = BigDecimal.ZERO;

        if (entity.getProduct() != null) {
            unitPrice = entity.getProduct().getPrice() != null
                    ? entity.getProduct().getPrice()
                    : (entity.getProduct().getMrp() != null ? entity.getProduct().getMrp() : BigDecimal.ZERO);
        }

        BigDecimal itemTotal = unitPrice.multiply(
                BigDecimal.valueOf(entity.getQuantity())
        );

        return CartItemResponseDTO.builder()
                .cartItemId(entity.getCartItemId())   // ✅ no conversion
                .productId(entity.getProduct() != null
                        ? entity.getProduct().getProductId()
                        : null)
                .productName(entity.getProduct() != null
                        ? entity.getProduct().getName()
                        : null)
                .quantity(entity.getQuantity())
                .price(entity.getProduct() != null
                        ? entity.getProduct().getPrice()
                        : null)
                .discountPrice(entity.getProduct() != null
                        ? entity.getProduct().getDiscountPrice()
                        : null)
                .itemTotal(itemTotal)
                .productImageUrl(entity.getProduct() != null
                        ? entity.getProduct().getImageUrl()
                        : null)
                .build();
    }

    public CartResponseDTO toDto(Cart cart, List<CartItem> items) {
        if (cart == null) {
            return null;
        }

        List<CartItemResponseDTO> itemDTOs = items.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        BigDecimal totalAmount = itemDTOs.stream()
                .map(CartItemResponseDTO::getItemTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return CartResponseDTO.builder()
                .cartId(cart.getCartId() != null
                        ? Long.valueOf(cart.getCartId())
                        : null)
                .userId(cart.getUser() != null && cart.getUser().getUserId() != null
                        ? Long.valueOf(cart.getUser().getUserId())
                        : null)
                .items(itemDTOs)
                .totalAmount(totalAmount)
                .build();
    }
}