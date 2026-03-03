package com.rev.app.service.impl;

import com.rev.app.entity.Category;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.ICategoryRepository;
import com.rev.app.service.ICategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);
    private final ICategoryRepository icategoryRepository;

    @Override
    public List<Category> getAllCategories() {
        logger.debug("Fetching all categories");
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
