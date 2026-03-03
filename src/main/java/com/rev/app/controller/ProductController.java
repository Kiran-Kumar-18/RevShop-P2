package com.rev.app.controller;

import com.rev.app.dto.ProductRequestDTO;
import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.IFileUploadService;
import com.rev.app.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger logger = LogManager.getLogger(ProductController.class);
    private final IProductService iproductService;
    private final IFileUploadService ifileUploadService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductResponseDTO>>> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) Integer categoryId, @RequestParam(required = false) String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponseDTO> products;
        if (keyword != null && !keyword.trim().isEmpty()) {
            products = iproductService.searchActiveProducts(keyword.trim(), pageable);
        } else if (categoryId != null) {
            products = iproductService.getActiveProductsByCategory(categoryId, pageable);
        } else {
            products = iproductService.getAllActiveProducts(pageable);
        }
        return ResponseEntity.ok(ApiResponse.success(products, "Products fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductById(@PathVariable Integer id) {
        ProductResponseDTO product = iproductService.getActiveProductById(id);
        return ResponseEntity.ok(ApiResponse.success(product, "Product fetched successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductResponseDTO>> createProduct(@Valid @RequestBody ProductRequestDTO request) {
        logger.info("REST request to create product (JSON): {}", request.getName());
        ProductResponseDTO newProduct = iproductService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(newProduct, "Product created successfully"));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ProductResponseDTO>> createProductWithImage(
            @RequestPart("product") @Valid ProductRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        logger.info("REST request to create product (Multipart): {}", request.getName());
        
        if (image != null && !image.isEmpty()) {
            String imageUrl = ifileUploadService.uploadFile(image);
            request.setImageUrl(imageUrl);
        }
        
        ProductResponseDTO newProduct = iproductService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(newProduct, "Product created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductRequestDTO request) {
        ProductResponseDTO updatedProduct = iproductService.updateProduct(id, request);
        return ResponseEntity.ok(ApiResponse.success(updatedProduct, "Product updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Integer id) {
        logger.info("REST request to delete product ID: {}", id);
        iproductService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Product deleted successfully"));
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> updateStock(@PathVariable Integer id, @RequestParam Integer quantityChange) {
        ProductResponseDTO product = iproductService.updateStock(id, quantityChange);
        return ResponseEntity.ok(ApiResponse.success(product, "Stock updated successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public ProductController(final IProductService iproductService, final IFileUploadService ifileUploadService) {
        this.iproductService = iproductService;
        this.ifileUploadService = ifileUploadService;
    }
}
