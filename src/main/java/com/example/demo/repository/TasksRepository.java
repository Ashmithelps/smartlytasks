package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tasks;
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{
        List<Tasks> findByCategory_Categoryid(Long categoryid);

}
