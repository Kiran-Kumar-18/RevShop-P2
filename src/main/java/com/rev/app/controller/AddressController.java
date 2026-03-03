package com.rev.app.controller;

import com.rev.app.dto.AddressRequestDTO;
import com.rev.app.dto.AddressResponseDTO;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private static final Logger logger = LogManager.getLogger(AddressController.class);

    private final IAddressService iaddressService;

    public AddressController(IAddressService iaddressService) {
        this.iaddressService = iaddressService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<AddressResponseDTO>> createAddress(
            @PathVariable Integer userId,
            @Valid @RequestBody AddressRequestDTO request) {

        logger.info("Creating new address for User ID: {}", userId);
        AddressResponseDTO response = iaddressService.createAddress(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Address created successfully"));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<ApiResponse<AddressResponseDTO>> updateAddress(
            @PathVariable Integer addressId,
            @Valid @RequestBody AddressRequestDTO request) {

        logger.info("Updating address ID: {}", addressId);
        AddressResponseDTO response = iaddressService.updateAddress(addressId, request);
        return ResponseEntity.ok(
                ApiResponse.success(response, "Address updated successfully"));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<ApiResponse<Void>> deleteAddress(
            @PathVariable Integer addressId) {

        logger.info("Deleting address ID: {}", addressId);
        iaddressService.deleteAddress(addressId);
        return ResponseEntity.ok(
                ApiResponse.success(null, "Address deleted successfully"));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<ApiResponse<AddressResponseDTO>> getAddressById(
            @PathVariable Integer addressId) {

        AddressResponseDTO response = iaddressService.getAddressById(addressId);
        return ResponseEntity.ok(
                ApiResponse.success(response, "Address fetched successfully"));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<AddressResponseDTO>>> getUserAddresses(
            @PathVariable Integer userId) {

        List<AddressResponseDTO> response = iaddressService.getUserAddresses(userId);
        return ResponseEntity.ok(
                ApiResponse.success(response, "User addresses fetched successfully"));
    }
}
