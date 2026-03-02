package com.rev.app.service.impl;

import com.rev.app.entity.Category;
import com.rev.app.exception.ResourceNotFoundException;
import com.rev.app.repository.ICategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void getAllCategories_Success() {
        when(categoryRepository.findAll()).thenReturn(List.of(new Category()));
        List<Category> result = categoryService.getAllCategories();
        assertFalse(result.isEmpty());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void getCategoryById_Success() {
        Category category = new Category();
        category.setCategoryId(1);
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));

        Category result = categoryService.getCategoryById(1);

        assertNotNull(result);
        assertEquals(1, result.getCategoryId());
    }

    @Test
    void getCategoryById_NotFound() {
        when(categoryRepository.findById(99)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> categoryService.getCategoryById(99));
    }
}
