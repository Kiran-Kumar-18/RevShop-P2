package com.rev.app.mapper;

import com.rev.app.dto.CartItemResponseDTO;
import com.rev.app.dto.CartResponseDTO;
import com.rev.app.entity.Cart;
import com.rev.app.entity.CartItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartItemResponseDTO toDto(CartItem entity) {
        if (entity == null) {
            return null;
        }

        BigDecimal mrp = (entity.getProduct() != null && entity.getProduct().getMrp() != null) 
                ? entity.getProduct().getMrp().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal originalPrice = (entity.getProduct() != null && entity.getProduct().getPrice() != null)
                ? entity.getProduct().getPrice().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal unitDiscount = (entity.getProduct() != null && entity.getProduct().getDiscountPrice() != null)
                ? entity.getProduct().getDiscountPrice().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal finalUnitPrice = originalPrice.subtract(unitDiscount).setScale(2, RoundingMode.HALF_UP);
        
        BigDecimal quantity = BigDecimal.valueOf(entity.getQuantity());
        BigDecimal itemTotal = finalUnitPrice.multiply(quantity).setScale(2, RoundingMode.HALF_UP);
        BigDecimal itemDiscount = unitDiscount.multiply(quantity).setScale(2, RoundingMode.HALF_UP);

        return CartItemResponseDTO.builder()
                .cartItemId(entity.getCartItemId())
                .productId(entity.getProduct() != null ? entity.getProduct().getProductId() : null)
                .productName(entity.getProduct() != null ? entity.getProduct().getName() : null)
                .quantity(entity.getQuantity())
                .price(originalPrice)
                .mrp(mrp)
                .discountPrice(unitDiscount)
                .itemDiscount(itemDiscount)
                .itemTotal(itemTotal)
                .productImageUrl(entity.getProduct() != null ? entity.getProduct().getImageUrl() : null)
                .build();
    }

    public CartResponseDTO toDto(Cart cart, List<CartItem> items) {
        if (cart == null) {
            return null;
        }

        List<CartItemResponseDTO> itemDTOs = items.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        BigDecimal totalMrp = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalPriceBeforeDiscount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalDiscount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalAmount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

        for (CartItemResponseDTO item : itemDTOs) {
            BigDecimal qty = BigDecimal.valueOf(item.getQuantity());
            totalMrp = totalMrp.add(item.getMrp().multiply(qty).setScale(2, RoundingMode.HALF_UP));
            totalPriceBeforeDiscount = totalPriceBeforeDiscount.add(item.getPrice().multiply(qty).setScale(2, RoundingMode.HALF_UP));
            totalDiscount = totalDiscount.add(item.getItemDiscount().setScale(2, RoundingMode.HALF_UP));
            totalAmount = totalAmount.add(item.getItemTotal().setScale(2, RoundingMode.HALF_UP));
        }

        return CartResponseDTO.builder()
                .cartId(cart.getCartId() != null ? Long.valueOf(cart.getCartId()) : null)
                .userId(cart.getUser() != null && cart.getUser().getUserId() != null ? Long.valueOf(cart.getUser().getUserId()) : null)
                .items(itemDTOs)
                .totalMrp(totalMrp)
                .totalPriceBeforeDiscount(totalPriceBeforeDiscount)
                .totalDiscount(totalDiscount)
                .totalAmount(totalAmount)
                .build();
    }
}