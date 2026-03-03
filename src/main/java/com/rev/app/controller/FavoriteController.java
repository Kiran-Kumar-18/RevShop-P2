package com.rev.app.controller;

import com.rev.app.dto.FavoriteResponseDTO;
import com.rev.app.mapper.FavoriteMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IFavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    private static final Logger logger = LogManager.getLogger(FavoriteController.class);
    private final IFavoriteService ifavoriteService;
    private final FavoriteMapper favoriteMapper;

    @PostMapping("/{userId}/{productId}")
    public ResponseEntity<ApiResponse<FavoriteResponseDTO>> addFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        logger.info("Adding favorite: User ID: {}, Product ID: {}", userId, productId);
        FavoriteResponseDTO favorite = favoriteMapper.toDto(ifavoriteService.addFavorite(userId, productId));
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(favorite, "Favorite added successfully"));
    }

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<ApiResponse<Void>> removeFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        logger.info("Removing favorite: User ID: {}, Product ID: {}", userId, productId);
        ifavoriteService.removeFavorite(userId, productId);
        return ResponseEntity.ok(ApiResponse.success(null, "Favorite removed successfully"));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<FavoriteResponseDTO>>> getUserFavorites(@PathVariable Integer userId) {
        List<FavoriteResponseDTO> favorites = ifavoriteService.getUserFavorites(userId).stream().map(favoriteMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(ApiResponse.success(favorites, "User favorites fetched successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public FavoriteController(final IFavoriteService ifavoriteService, final FavoriteMapper favoriteMapper) {
        this.ifavoriteService = ifavoriteService;
        this.favoriteMapper = favoriteMapper;
    }
}
