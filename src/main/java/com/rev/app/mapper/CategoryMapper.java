package com.rev.app.mapper;

import com.rev.app.dto.CategoryResponseDTO;
import com.rev.app.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponseDTO toDto(Category entity) {
        if (entity == null) {
            return null;
        }

        return CategoryResponseDTO.builder()
                .categoryId(entity.getCategoryId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}

