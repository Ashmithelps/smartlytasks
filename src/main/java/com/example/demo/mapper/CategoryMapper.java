package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CategoryRequestDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.model.Category;
@Component
public class CategoryMapper {
    // request to entity
    public Category toEntity(CategoryRequestDto dto){
        Category category=new Category();
        category.setCategoryName(dto.getCategoryName());
        return category;
    }
    // entity to response
    public  CategoryResponseDto toResponseDto(Category category){
        CategoryResponseDto dto=new CategoryResponseDto();
        dto.setCategoryid(category.getCategoryid());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }
}
