package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.enums.TaskPriority;
import com.example.demo.enums.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TasksRequestDto {
    @NotBlank(message = "title is required")
    @Size(min = 3, max = 100)
    private String title;
    @Size(max = 500)
    private String description;
    @NotNull(message = "category id is required")
    private Long categoryid;
    @NotNull
    private TaskPriority priority;
    private LocalDate dueDate;
    private TaskStatus status;



}
