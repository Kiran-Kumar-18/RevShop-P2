package com.rev.app.mapper;

import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO toDto(Product entity) {
        if (entity == null) {
            return null;
        }

        String imgUrl = entity.getImageUrl();
        if (imgUrl == null || imgUrl.trim().isEmpty()) {
            if (entity.getCategory() != null && entity.getCategory().getName() != null) {
                String catName = entity.getCategory().getName().toLowerCase().replaceAll("\\s+", "-");
                imgUrl = "https://placehold.co/400x400/png?text=" + catName;
            } else {
                imgUrl = "https://placehold.co/400x400/png?text=Product";
            }
        }

        java.math.BigDecimal mrp = entity.getMrp();
        java.math.BigDecimal price = entity.getPrice();
        if (price != null) {
            java.math.BigDecimal minMrp = price.multiply(new java.math.BigDecimal("1.25"));
            if (mrp == null || mrp.compareTo(minMrp) < 0) {
                mrp = minMrp;
            }
        }

        return ProductResponseDTO.builder()
                .productId(entity.getProductId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .mrp(mrp)
                .discountPrice(entity.getDiscountPrice())
                .stockQuantity(entity.getStockQuantity())
                .isActive(entity.getIsActive())
                .sellerId(entity.getSeller() != null && entity.getSeller().getUser() != null ? entity.getSeller().getUser().getUserId() : null)
                .categoryName(entity.getCategory() != null ? entity.getCategory().getName() : null)
                .sellerBusinessName(entity.getSeller() != null ? entity.getSeller().getBusinessName() : null)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .imageUrl(imgUrl)
                .averageRating(0.0)
                .soldCount(0)
                .build();
    }
}

