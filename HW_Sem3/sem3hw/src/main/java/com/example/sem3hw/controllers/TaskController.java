package com.example.sem3hw.controllers;

import com.example.sem3hw.domain.User;
import com.example.sem3hw.services.DataProcessingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getListOfUsers());
    }


    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age){
        return service.filterUsersByAge(service.getListOfUsers(), age);
    }


    @GetMapping("/calc")
    public Double calculateAverageAge(){
        return service.calculateAverageAge(service.getListOfUsers());
    }

    public TaskController(DataProcessingService service) {
        this.service = service;
    }
}
