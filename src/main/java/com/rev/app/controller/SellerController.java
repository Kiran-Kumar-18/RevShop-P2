package com.rev.app.controller;

import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.dto.SellerResponseDTO;
import com.rev.app.mapper.ProductMapper;
import com.rev.app.mapper.SellerMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.ISellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    private static final Logger logger = LogManager.getLogger(SellerController.class);
    private final ISellerService isellerService;
    private final SellerMapper sellerMapper;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SellerResponseDTO>> getSellerById(@PathVariable Integer id) {
        SellerResponseDTO seller = sellerMapper.toDto(isellerService.getSellerById(id));
        return ResponseEntity.ok(ApiResponse.success(seller, "Seller fetched successfully"));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getSellerProducts(@PathVariable Integer id) {
        List<ProductResponseDTO> products = isellerService.getSellerProducts(id).stream().map(productMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(ApiResponse.success(products, "Seller products fetched successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public SellerController(final ISellerService isellerService, final SellerMapper sellerMapper, final ProductMapper productMapper) {
        this.isellerService = isellerService;
        this.sellerMapper = sellerMapper;
        this.productMapper = productMapper;
    }
}
