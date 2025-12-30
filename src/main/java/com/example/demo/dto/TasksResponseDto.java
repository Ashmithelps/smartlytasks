package com.example.demo.dto;



import java.time.LocalDate;

import com.example.demo.enums.TaskPriority;
import com.example.demo.enums.TaskStatus;

import lombok.Data;

@Data
public class TasksResponseDto {
    private Long taskid;
    private String title;
    private String description;

    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;
    
    private Long categoryid;
    private String categoryName;
   

}