package com.example.taskManager.repository;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.TaskStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    @Modifying
    @Query("UPDATE Task t SET t.status = ?2 WHERE t.id = ?1")
    void changeStatus(Long id, TaskStatus task);

    List<Task> findAllByStatus(TaskStatus status);
}
