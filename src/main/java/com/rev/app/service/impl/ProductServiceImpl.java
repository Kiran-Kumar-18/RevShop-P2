package com.rev.app.service.impl;

import com.rev.app.dto.ProductRequestDTO;
import com.rev.app.dto.ProductResponseDTO;
import com.rev.app.entity.Category;
import com.rev.app.entity.Product;
import com.rev.app.entity.Seller;
import com.rev.app.mapper.ProductMapper;
import com.rev.app.repository.ICategoryRepository;
import com.rev.app.repository.IProductRepository;
import com.rev.app.repository.ISellerRepository;
import com.rev.app.repository.IReviewRepository;
import com.rev.app.repository.IOrderItemRepository;
import com.rev.app.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository iproductRepository;
    private final ICategoryRepository icategoryRepository;
    private final ISellerRepository isellerRepository;
    private final ProductMapper productMapper;
    private final IReviewRepository ireviewRepository;
    private final IOrderItemRepository iorderItemRepository;

    @Override
    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {
        return iproductRepository.findAll(pageable).map(productMapper::toDto).map(this::populateStats);
    }

    @Override
    public Page<ProductResponseDTO> getProductsByCategory(Integer categoryId, Pageable pageable) {
        return iproductRepository.findByCategoryCategoryId(categoryId, pageable).map(productMapper::toDto).map(this::populateStats);
    }

    @Override
    public Page<ProductResponseDTO> searchProducts(String keyword, Pageable pageable) {
        return iproductRepository.findByNameContainingIgnoreCase(keyword, pageable).map(productMapper::toDto).map(this::populateStats);
    }

    @Override
    public ProductResponseDTO getProductById(Integer id) {
        if (id == null) {
            throw new RuntimeException("Product ID must not be null");
        }
        Product product = iproductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return populateStats(productMapper.toDto(product));
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        if (request.getCategoryId() == null) {
            throw new RuntimeException("Category ID must not be null");
        }
        Category category = icategoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        if (request.getSellerId() == null) {
            throw new RuntimeException("Seller ID must not be null");
        }
        Seller seller = isellerRepository.findByUserUserId(request.getSellerId()).orElseThrow(() -> new RuntimeException("Seller not found for User ID: " + request.getSellerId()));
        Product product = Product.builder()
            .name(request.getName())
            .description(request.getDescription())
            .price(request.getPrice())
            .mrp(request.getMrp())
            .discountPrice(request.getDiscountPrice())
            .stockQuantity(request.getStockQuantity())
            .stockThreshold(request.getStockThreshold())
            .isActive(request.getIsActive())
            .category(category)
            .seller(seller)
            .imageUrl(request.getImageUrl())
            .build();
        return productMapper.toDto(iproductRepository.save(product));
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductRequestDTO request) {
        if (id == null) {
            throw new RuntimeException("Product ID must not be null");
        }
        Product product = iproductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setMrp(request.getMrp());
        product.setDiscountPrice(request.getDiscountPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setStockThreshold(request.getStockThreshold());
        product.setIsActive(request.getIsActive());
        product.setImageUrl(request.getImageUrl());
        return productMapper.toDto(iproductRepository.save(product));
    }

    @Override
    public void deleteProduct(Integer id) {
        if (id == null) {
            throw new RuntimeException("Product ID must not be null");
        }
        iproductRepository.deleteById(id);
    }

    @Override
    public Page<ProductResponseDTO> getAllActiveProducts(Pageable pageable) {
        return iproductRepository.findByIsActiveTrue(pageable).map(productMapper::toDto).map(this::populateStats);
    }

    @Override
    public Page<ProductResponseDTO> getActiveProductsByCategory(Integer categoryId, Pageable pageable) {
        return iproductRepository.findByCategoryCategoryIdAndIsActiveTrue(categoryId, pageable).map(productMapper::toDto).map(this::populateStats);
    }

    @Override
    public Page<ProductResponseDTO> searchActiveProducts(String keyword, Pageable pageable) {
        return iproductRepository.findByNameContainingIgnoreCaseAndIsActiveTrue(keyword, pageable).map(productMapper::toDto).map(this::populateStats);
    }

    @Override
    public ProductResponseDTO getActiveProductById(Integer id) {
        if (id == null) {
            throw new RuntimeException("Product ID must not be null");
        }
        Product product = iproductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getIsActive() == null || !product.getIsActive()) {
            throw new RuntimeException("Product is not active");
        }
        return populateStats(productMapper.toDto(product));
    }

    @Override
    public ProductResponseDTO updateStock(Integer id, Integer quantityChange) {
        if (id == null) {
            throw new RuntimeException("Product ID must not be null");
        }
        Product product = iproductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        int newQuantity = (product.getStockQuantity() == null ? 0 : product.getStockQuantity()) + quantityChange;
        if (newQuantity < 0) newQuantity = 0;
        product.setStockQuantity(newQuantity);
        return populateStats(productMapper.toDto(iproductRepository.save(product)));
    }

    @Override
    public Page<ProductResponseDTO> filterActiveProducts(Integer categoryId, java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice, String keyword, Double minRating, Pageable pageable) {
        return iproductRepository.filterProducts(categoryId, minPrice, maxPrice, keyword, minRating, pageable)
                .map(productMapper::toDto)
                .map(this::populateStats);
    }

    private ProductResponseDTO populateStats(ProductResponseDTO dto) {
        if (dto == null) return null;
        Double avgRating = ireviewRepository.getAverageRatingByProductId(dto.getProductId());
        dto.setAverageRating(avgRating != null ? avgRating : 0.0);
        Integer soldCount = iorderItemRepository.countSoldCountByProductId(dto.getProductId());
        dto.setSoldCount(soldCount != null ? soldCount : 0);
        return dto;
    }

    @java.lang.SuppressWarnings("all")
    
    public ProductServiceImpl(final IProductRepository iproductRepository, final ICategoryRepository icategoryRepository, final ISellerRepository isellerRepository, final ProductMapper productMapper, final IReviewRepository ireviewRepository, final IOrderItemRepository iorderItemRepository) {
        this.iproductRepository = iproductRepository;
        this.icategoryRepository = icategoryRepository;
        this.isellerRepository = isellerRepository;
        this.productMapper = productMapper;
        this.ireviewRepository = ireviewRepository;
        this.iorderItemRepository = iorderItemRepository;
    }
}
