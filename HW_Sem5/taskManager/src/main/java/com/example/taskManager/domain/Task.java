package com.example.taskManager.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskStatus status;

    @Column(name = "time_of_creation", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timeOfCreation;

    @PrePersist
    private void createTask(){
        if (this.status == null)
            this.status = TaskStatus.NOT_STARTED;
        if (this.timeOfCreation == null)
            this.timeOfCreation = LocalDateTime.now();
    }
}
