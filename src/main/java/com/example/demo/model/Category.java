package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;
    @Column(name = "categoryname" , nullable = false, unique = true)
    
    private String categoryName;
     public Category() {}

    // ✅ Optional constructor
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    
}
