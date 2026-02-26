package com.rev.app.mapper;

import com.rev.app.dto.FavoriteResponseDTO;
import com.rev.app.entity.Favorite;
import org.springframework.stereotype.Component;

@Component
public class FavoriteMapper {

    public FavoriteResponseDTO toDto(Favorite entity) {
        if (entity == null) {
            return null;
        }

        com.rev.app.entity.Product product = entity.getProduct();
        String imgUrl = null;
        java.math.BigDecimal price = null;
        java.math.BigDecimal mrp = null;
        String categoryName = null;

        if (product != null) {
            imgUrl = product.getImageUrl();
            if (imgUrl == null || imgUrl.trim().isEmpty()) {
                if (product.getCategory() != null && product.getCategory().getName() != null) {
                    String catName = product.getCategory().getName().toLowerCase().replaceAll("\\s+", "-");
                    imgUrl = "https://placehold.co/400x400/png?text=" + catName;
                } else {
                    imgUrl = "https://placehold.co/400x400/png?text=Product";
                }
            }

            price = product.getPrice();
            mrp = product.getMrp();
            if (price != null) {
                java.math.BigDecimal minMrp = price.multiply(new java.math.BigDecimal("1.25"));
                if (mrp == null || mrp.compareTo(minMrp) < 0) {
                    mrp = minMrp;
                }
            }
            categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
        }

        return FavoriteResponseDTO.builder()
                .favoriteId(entity.getFavoriteId())
                .userId(entity.getUser() != null ? entity.getUser().getUserId() : null)
                .productId(product != null ? product.getProductId() : null)
                .productName(product != null ? product.getName() : null)
                .imageUrl(imgUrl)
                .price(price)
                .mrp(mrp)
                .categoryName(categoryName)
                .build();
    }
}

