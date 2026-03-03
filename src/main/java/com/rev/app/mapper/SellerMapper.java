package com.rev.app.mapper;

import com.rev.app.dto.SellerResponseDTO;
import com.rev.app.entity.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {

    public SellerResponseDTO toDto(Seller entity) {
        if (entity == null) {
            return null;
        }

        return SellerResponseDTO.builder()
                .sellerId(entity.getSellerId())
                .userName(entity.getUser() != null ? entity.getUser().getName() : null)
                .businessName(entity.getBusinessName())
                .gstNumber(entity.getGstNumber())
                .address(entity.getAddress())
                .totalRevenue(entity.getTotalRevenue())
                .build();
    }
}

