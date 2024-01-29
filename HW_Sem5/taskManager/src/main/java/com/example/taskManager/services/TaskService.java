package com.example.taskManager.services;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.TaskStatus;
import com.example.taskManager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTask() {
        return repository.findAll();
    }

    @Transactional
    public Optional<Task> changeStatusOfTask(Long id, TaskStatus newStatus) {
        repository.changeStatus(id, newStatus);
        return repository.findById(id);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public List<Task> findTasksByStatus(TaskStatus status){
        return repository.findAllByStatus(status);
    }
}
