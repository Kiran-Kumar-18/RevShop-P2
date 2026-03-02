package com.rev.app.service.impl;

import com.rev.app.dto.AddressRequestDTO;
import com.rev.app.dto.AddressResponseDTO;
import com.rev.app.entity.Address;
import com.rev.app.entity.User;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.mapper.AddressMapper;
import com.rev.app.repository.IAddressRepository;
import com.rev.app.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {

    @Mock
    private IAddressRepository addressRepository;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private AddressMapper addressMapper;

    @InjectMocks
    private AddressServiceImpl addressService;

    private User user;
    private Address address;
    private AddressRequestDTO addressRequest;
    private AddressResponseDTO addressResponse;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1);

        address = Address.builder()
                .addressId(1)
                .user(user)
                .fullName("John Doe")
                .addressLine1("123 Street")
                .city("City")
                .state("State")
                .postalCode("12345")
                .country("Country")
                .addressType("Shipping")
                .build();

        addressRequest = AddressRequestDTO.builder()
                .fullName("John Doe")
                .addressLine1("123 Street")
                .city("City")
                .state("State")
                .postalCode("12345")
                .country("Country")
                .addressType("Shipping")
                .build();

        addressResponse = new AddressResponseDTO();
    }

    @Test
    void createAddress_Success() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        when(addressMapper.toDto(any(Address.class))).thenReturn(addressResponse);

        AddressResponseDTO result = addressService.createAddress(1, addressRequest);

        assertNotNull(result);
        verify(addressRepository, times(1)).save(any(Address.class));
    }

    @Test
    void createAddress_UserNotFound() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> addressService.createAddress(1, addressRequest));
    }

    @Test
    void updateAddress_Success() {
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        when(addressMapper.toDto(any(Address.class))).thenReturn(addressResponse);

        AddressResponseDTO result = addressService.updateAddress(1, addressRequest);

        assertNotNull(result);
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void deleteAddress_Success() {
        when(addressRepository.existsById(1)).thenReturn(true);

        addressService.deleteAddress(1);

        verify(addressRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteAddress_NotFound() {
        when(addressRepository.existsById(1)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> addressService.deleteAddress(1));
    }

    @Test
    void getAddressById_Success() {
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        when(addressMapper.toDto(address)).thenReturn(addressResponse);

        AddressResponseDTO result = addressService.getAddressById(1);

        assertNotNull(result);
    }

    @Test
    void getUserAddresses_Success() {
        when(addressRepository.findByUserUserId(1)).thenReturn(List.of(address));
        when(addressMapper.toDto(any(Address.class))).thenReturn(addressResponse);

        List<AddressResponseDTO> result = addressService.getUserAddresses(1);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}
