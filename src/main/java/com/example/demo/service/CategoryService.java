package com.example.demo.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryRequestDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    // constructor injection
    public CategoryService(CategoryRepository categoryRepository , CategoryMapper categoryMapper){
        this.categoryRepository= categoryRepository;
        this.categoryMapper=categoryMapper;
    }

    // create repository
    public CategoryResponseDto createCateogry(CategoryRequestDto requestDto){
        Category category=categoryMapper.toEntity(requestDto);
        Category saved=categoryRepository.save(category);
        return categoryMapper.toResponseDto(saved);
    }

    // get repository
    public List<CategoryResponseDto> getallCategories(){
        return categoryRepository.findAll().stream().map(categoryMapper::toResponseDto).toList();
    }

    // Get by id 
    public CategoryResponseDto getCategoryById(Long id){
        Category category=categoryRepository.findById(id)
                    .orElseThrow(()-> new RuntimeException("not found category"));

        return categoryMapper.toResponseDto(category);
    }

    // update 
    public CategoryResponseDto updateCategoryById(Long id, CategoryRequestDto requestDto){
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->  new RuntimeException("not found category"));
        category.setCategoryName(requestDto.getCategoryName());
        Category updated=categoryRepository.save(category);
        return categoryMapper.toResponseDto(updated);
    }

    // delete by id 
    public void deleteCategory(Long id){
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("not found category"));
        categoryRepository.delete(category);
    }

}
