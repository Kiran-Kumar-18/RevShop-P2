package com.rev.app.controller;

import com.rev.app.dto.CategoryResponseDTO;
import com.rev.app.mapper.CategoryMapper;
import com.rev.app.rest.ApiResponse;
import com.rev.app.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService icategoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDTO>>> getAllCategories() {
        List<CategoryResponseDTO> categories = icategoryService.getAllCategories().stream().map(categoryMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(ApiResponse.success(categories, "Categories fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> getCategoryById(@PathVariable Integer id) {
        CategoryResponseDTO category = categoryMapper.toDto(icategoryService.getCategoryById(id));
        return ResponseEntity.ok(ApiResponse.success(category, "Category fetched successfully"));
    }

    @java.lang.SuppressWarnings("all")
    
    public CategoryController(final ICategoryService icategoryService, final CategoryMapper categoryMapper) {
        this.icategoryService = icategoryService;
        this.categoryMapper = categoryMapper;
    }
}
