package com.example.demo.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.enums.TaskPriority;
import com.example.demo.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="tasks")

public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskid;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column
    private LocalDate dueDate;

    @Column
    private LocalDateTime createdAt;

    // @ManyToOne
    // @JoinColumn(name="user_id", nullable = true)
    // private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
        this.status=TaskStatus.PENDING;
    }

//     public void setCategory(Category category) {
//     this.category = category;
// }

}
