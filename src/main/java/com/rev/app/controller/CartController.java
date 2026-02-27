package com.rev.app.controller;

import com.rev.app.dto.CartRequestDTO;
import com.rev.app.dto.CartResponseDTO;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.ICartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final ICartService icartService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<CartResponseDTO>> getCart(@PathVariable Integer userId) {
        CartResponseDTO cart = icartService.getCartByUserId(userId);
        return ResponseEntity.ok(ApiResponse.success(cart, "Cart fetched successfully"));
    }

    @PostMapping("/{userId}/items")
    public ResponseEntity<ApiResponse<CartResponseDTO>> addItemToCart(@PathVariable Integer userId, @Valid @RequestBody CartRequestDTO request) {
        CartResponseDTO cart = icartService.addItemToCart(userId, request);
        return ResponseEntity.ok(ApiResponse.success(cart, "Item added to cart successfully"));
    }

    @DeleteMapping("/{userId}/items/{itemId}")
    public ResponseEntity<ApiResponse<CartResponseDTO>> removeItemFromCart(@PathVariable Integer userId, @PathVariable Integer itemId) {
        CartResponseDTO cart = icartService.removeItemFromCart(userId, itemId);
        return ResponseEntity.ok(ApiResponse.success(cart, "Item removed from cart successfully"));
    }

    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<ApiResponse<CartResponseDTO>> clearCart(@PathVariable Integer userId) {
        CartResponseDTO cart = icartService.clearCart(userId);
        return ResponseEntity.ok(ApiResponse.success(cart, "Cart cleared successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public CartController(final ICartService icartService) {
        this.icartService = icartService;
    }
}
