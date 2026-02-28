package com.rev.app.service.impl;

import com.rev.app.dto.AddressRequestDTO;
import com.rev.app.dto.AddressResponseDTO;
import com.rev.app.entity.Address;
import com.rev.app.entity.User;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.mapper.AddressMapper;
import com.rev.app.repository.IAddressRepository;
import com.rev.app.repository.IUserRepository;
import com.rev.app.service.IAddressService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddressService {
    private final IAddressRepository iaddressRepository;
    private final IUserRepository iuserRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponseDTO createAddress(Integer userId, AddressRequestDTO request) {
        if (userId == null) {
            throw new ResourceNotFoundException("User ID must not be null");
        }
        User user = iuserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Address address = Address.builder().user(user).fullName(request.getFullName()).phone(request.getPhone()).addressLine1(request.getAddressLine1()).addressLine2(request.getAddressLine2()).city(request.getCity()).state(request.getState()).postalCode(request.getPostalCode()).country(request.getCountry()).addressType(request.getAddressType()).build();
        return addressMapper.toDto(iaddressRepository.save(address));
    }

    @Override
    public AddressResponseDTO updateAddress(Integer addressId, AddressRequestDTO request) {
        if (addressId == null) {
            throw new ResourceNotFoundException("Address ID must not be null");
        }
        Address address = iaddressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        address.setFullName(request.getFullName());
        address.setPhone(request.getPhone());
        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setPostalCode(request.getPostalCode());
        address.setCountry(request.getCountry());
        address.setAddressType(request.getAddressType());
        return addressMapper.toDto(iaddressRepository.save(address));
    }

    @Override
    public void deleteAddress(Integer addressId) {
        if (addressId == null) {
            throw new ResourceNotFoundException("Address ID must not be null");
        }
        if (!iaddressRepository.existsById(addressId)) {
            throw new ResourceNotFoundException("Address not found");
        }
        iaddressRepository.deleteById(addressId);
    }

    @Override
    public AddressResponseDTO getAddressById(Integer addressId) {
        if (addressId == null) {
            throw new ResourceNotFoundException("Address ID must not be null");
        }
        Address address = iaddressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressResponseDTO> getUserAddresses(Integer userId) {
        return iaddressRepository.findByUserUserId(userId).stream().map(addressMapper::toDto).collect(Collectors.toList());
    }

    @java.lang.SuppressWarnings("all")
    
    public AddressServiceImpl(final IAddressRepository iaddressRepository, final IUserRepository iuserRepository, final AddressMapper addressMapper) {
        this.iaddressRepository = iaddressRepository;
        this.iuserRepository = iuserRepository;
        this.addressMapper = addressMapper;
    }
}
