package com.example.taskManager.controllers;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.TaskStatus;
import com.example.taskManager.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping("/new")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }

//    @GetMapping("/status/{status}")
//    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
//        return taskService.findTasksByStatus(status);
//    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.changeStatusOfTask(id, task.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
