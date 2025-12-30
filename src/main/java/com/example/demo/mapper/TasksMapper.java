package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.TasksRequestDto;
import com.example.demo.dto.TasksResponseDto;
import com.example.demo.model.Tasks;
import com.example.demo.model.Category;

@Component
public class TasksMapper {
    // request to entity
    public Tasks toentity(TasksRequestDto dto, Category category){
        Tasks tasks=new Tasks();
        tasks.setTitle(dto.getTitle());
        tasks.setDescription(dto.getDescription());
        tasks.setCategory(category);
        tasks.setPriority(dto.getPriority());
        tasks.setStatus(dto.getStatus());
        tasks.setDueDate(dto.getDueDate());
        return tasks;
    }


    // entity to response
    public TasksResponseDto toResponseDto(Tasks tasks){     
        TasksResponseDto dto=new TasksResponseDto();
        dto.setTaskid(tasks.getTaskid());
        dto.setTitle(tasks.getTitle());
        dto.setDescription(tasks.getDescription());
        dto.setStatus(tasks.getStatus());
        dto.setDueDate(tasks.getDueDate());
        dto.setPriority(tasks.getPriority());
        if(tasks.getCategory()!=null){
            dto.setCategoryid(tasks.getCategory().getCategoryid());
            dto.setCategoryName(tasks.getCategory().getCategoryName());
        }
       
        return dto;
    }
}
