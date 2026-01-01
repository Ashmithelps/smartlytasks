package com.example.demo.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.TasksRequestDto;
import com.example.demo.dto.TasksResponseDto;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.mapper.TasksMapper;
import com.example.demo.model.Category;
import com.example.demo.model.Tasks;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TasksRepository;

@Service
public class TasksService {
        private final TasksRepository tasksRepository;
        private final CategoryRepository categoryRepository;
        private final TasksMapper tasksMapper;

        public TasksService(TasksRepository tasksRepository, CategoryRepository categoryRepository, TasksMapper tasksMapper){
            this.tasksRepository=tasksRepository;
            this.categoryRepository=categoryRepository;
            this.tasksMapper=tasksMapper;
        }

        // creating a task under a single category
        public TasksResponseDto createTasks(TasksRequestDto requestDto){
            Category category=categoryRepository.findById(requestDto.getCategoryid())
                .orElseThrow(()-> new ResourceNotFound("category not found"));
            Tasks tasks=tasksMapper.toentity(requestDto, category);
            Tasks savedTasks=tasksRepository.save(tasks);
            return tasksMapper.toResponseDto(savedTasks);
        }
        // get all tasks
        public Page <TasksResponseDto> getAllTasks(Pageable pageable){
            return tasksRepository.findAll(pageable)
                    .map(tasksMapper::toResponseDto);
        }

        // get all tasks by id 
        public TasksResponseDto getTaskById(Long id){
            Tasks tasks= tasksRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFound("Task not found"));
            return tasksMapper.toResponseDto(tasks);
        }

        // get task by category
        public List<TasksResponseDto> getTasksByCategory(Long categoryid){
            return tasksRepository.findByCategory_Categoryid(categoryid)
                    .stream()
                    .map(tasksMapper::toResponseDto)
                    .toList();
        }

        // update anything in the task
        public TasksResponseDto updateTasks(Long id , TasksRequestDto requestDto){
            Tasks existingTasks=tasksRepository.findById(id)
                                .orElseThrow(()-> new ResourceNotFound("Tasks not found"));
            existingTasks.setTitle(requestDto.getTitle());
            existingTasks.setDescription(requestDto.getDescription());
            existingTasks.setStatus(requestDto.getStatus());
            existingTasks.setDueDate(requestDto.getDueDate());
            Tasks updatedTasks=tasksRepository.save(existingTasks);
            return tasksMapper.toResponseDto(updatedTasks);
        }
        
        // delete any task

        public void deleteTasksByid(Long id){
            Tasks tasks=tasksRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFound("task already deleted or not found"));
            tasksRepository.delete(tasks);
        }
}
