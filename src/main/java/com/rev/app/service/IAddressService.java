package com.rev.app.service;

import com.rev.app.dto.AddressRequestDTO;
import com.rev.app.dto.AddressResponseDTO;

import java.util.List;

public interface IAddressService {
    AddressResponseDTO createAddress(Integer userId, AddressRequestDTO request);
    AddressResponseDTO updateAddress(Integer addressId, AddressRequestDTO request);
    void deleteAddress(Integer addressId);
    AddressResponseDTO getAddressById(Integer addressId);
    List<AddressResponseDTO> getUserAddresses(Integer userId);
}


