package com.example.demo.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryRequestDto;
import com.example.demo.dto.CategoryResponseDto;

import com.example.demo.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    //constructor injection
    public CategoryController (CategoryService categoryservice){
        this.categoryService=categoryservice;
    }

    // create HTTP request
    // POST
    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCateogry( @Valid @RequestBody CategoryRequestDto requestDto){
        CategoryResponseDto response= categoryService.createCateogry(requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // get all categories
    // GET
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getallCategories(){

        return ResponseEntity.ok(categoryService.getallCategories());
    }

    // get by id 
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id){

        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategoryById(@PathVariable Long id , @Valid @RequestBody CategoryRequestDto requestDto){
        return ResponseEntity.ok(categoryService.updateCategoryById(id, requestDto));
    }
    // delete by id 
    // DELETE 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();

    }




}
