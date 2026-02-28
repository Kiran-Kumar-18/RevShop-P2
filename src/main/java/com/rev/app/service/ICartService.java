package com.rev.app.service;

import com.rev.app.dto.CartRequestDTO;
import com.rev.app.dto.CartResponseDTO;

public interface ICartService {
    CartResponseDTO getCartByUserId(Integer userId);
    CartResponseDTO addItemToCart(Integer userId, CartRequestDTO request);
    CartResponseDTO removeItemFromCart(Integer userId, Integer itemId);
    CartResponseDTO clearCart(Integer userId);
}


