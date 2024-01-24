package com.example.sem4hw.services;

import com.example.sem4hw.domain.Task;
import com.example.sem4hw.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    TaskRepository repository;

    public List<Task> getAll(){
        return repository.getAll();
    }

    public Task addTask(Task task){
        repository.addTask(task);
        return task;
    }

    public void deleteTask(Long id) {
        repository.deleteTask(id);
    }
    public Task updateTask(Task task){
        return repository.updateTask(task);
    }
    public Task getOne(Long id){
        return repository.getOne(id);
    }
}
