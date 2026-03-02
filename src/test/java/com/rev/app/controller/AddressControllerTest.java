package com.rev.app.controller;

import com.rev.app.dto.AddressRequestDTO;
import com.rev.app.dto.AddressResponseDTO;
import com.rev.app.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IAddressService addressService;

    @InjectMocks
    private AddressController addressController;

    private AddressResponseDTO addressResponseDTO;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(addressController).build();
        objectMapper = new ObjectMapper();

        addressResponseDTO = AddressResponseDTO.builder()
                .addressId(1)
                .fullName("John Doe")
                .phone("1234567890")
                .addressLine1("123 Street")
                .city("City")
                .state("State")
                .postalCode("12345")
                .country("Country")
                .addressType("Shipping")
                .build();
    }

    @Test
    public void givenUserId_whenGetUserAddresses_thenReturnList() throws Exception {
        when(addressService.getUserAddresses(anyInt())).thenReturn(Collections.singletonList(addressResponseDTO));

        mockMvc.perform(get("/api/addresses/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data[0].addressLine1").value("123 Street"));
    }

    @Test
    public void givenAddressId_whenGetAddressById_thenReturnAddress() throws Exception {
        when(addressService.getAddressById(anyInt())).thenReturn(addressResponseDTO);

        mockMvc.perform(get("/api/addresses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.addressId").value(1));
    }

    @Test
    public void givenValidRequest_whenAddAddress_thenReturnCreated() throws Exception {
        when(addressService.createAddress(anyInt(), any(AddressRequestDTO.class))).thenReturn(addressResponseDTO);

        mockMvc.perform(post("/api/addresses/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"addressLine1\": \"123 Street\", \"city\": \"City\", \"state\": \"State\", \"postalCode\": \"12345\", \"country\": \"Country\", \"fullName\": \"John Doe\", \"phone\": \"1234567890\", \"addressType\": \"Shipping\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Address created successfully"));
    }
}
