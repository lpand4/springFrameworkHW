package com.example.taskManager.services;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.TaskStatus;
import com.example.taskManager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public List<Task> findTasksByStatus(TaskStatus status) {
//        return repository.findTasksByStatus(status);
//    }

    public Task changeStatusOfTask(Long id, TaskStatus newStatus) {
        return repository.changeStatus(id, newStatus);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
