package com.rev.app.service.impl;

import com.rev.app.entity.Category;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.ICategoryRepository;
import com.rev.app.service.ICategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository icategoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return icategoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return icategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    @java.lang.SuppressWarnings("all")
    
    public CategoryServiceImpl(final ICategoryRepository icategoryRepository) {
        this.icategoryRepository = icategoryRepository;
    }
}
