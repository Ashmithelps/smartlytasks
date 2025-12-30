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

import com.example.demo.dto.TasksRequestDto;
import com.example.demo.dto.TasksResponseDto;

import com.example.demo.service.TasksService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tasks")
public class TasksController {


    private final TasksService tasksService;

    // constructor
    public TasksController(TasksService tasksService){
        this.tasksService=tasksService;
    }

    // creating tasks
    // post
    @PostMapping
    public ResponseEntity<TasksResponseDto> createTasks ( @Valid @RequestBody TasksRequestDto requestDto){
        TasksResponseDto response=tasksService.createTasks(requestDto);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    // get all tasks

    @GetMapping
    public ResponseEntity<List<TasksResponseDto>> getAllTasks(){
        return ResponseEntity.ok(tasksService.getAllTasks());
    }

    // get tasks by id 
    @GetMapping("/{id}")
    public ResponseEntity<TasksResponseDto> getTasksById(@PathVariable Long id){
        return ResponseEntity.ok(tasksService.getTaskById(id));
    }

    // get tasks by category 
    @GetMapping("/category/{categoryid}")
    public ResponseEntity <List<TasksResponseDto>> getTasksByCategory(@PathVariable Long categoryid){
        return ResponseEntity.ok(tasksService.getTasksByCategory(categoryid));
    }
    // update tasks
    @PutMapping("/{id}")
    public ResponseEntity<TasksResponseDto> updateTasks(@PathVariable Long id , @Valid @RequestBody TasksRequestDto requestDto){
        return ResponseEntity.ok(tasksService.updateTasks(id, requestDto));
    }
    // delete mapping 

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteById(@PathVariable Long id){
        tasksService.deleteTasksByid(id);
        return ResponseEntity.noContent().build();
    }





   
}
