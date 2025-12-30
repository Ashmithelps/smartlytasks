package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequestDto {
    
    @NotBlank(message = "Category name is required")
    @Size(min=3 , max=50)
    private String categoryName;


}
