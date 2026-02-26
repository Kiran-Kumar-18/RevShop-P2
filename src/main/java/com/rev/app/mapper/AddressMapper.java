package com.rev.app.mapper;

import com.rev.app.dto.AddressResponseDTO;
import com.rev.app.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressResponseDTO toDto(Address entity) {
        if (entity == null) {
            return null;
        }

        return AddressResponseDTO.builder()
                .addressId(entity.getAddressId())
                .userId(entity.getUser() != null ? entity.getUser().getUserId() : null)
                .fullName(entity.getFullName())
                .phone(entity.getPhone())
                .addressLine1(entity.getAddressLine1())
                .addressLine2(entity.getAddressLine2())
                .city(entity.getCity())
                .state(entity.getState())
                .postalCode(entity.getPostalCode())
                .country(entity.getCountry())
                .addressType(entity.getAddressType())
                .build();
    }
}

