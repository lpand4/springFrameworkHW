package com.example.sem3hw2.controllers;

import com.example.sem3hw2.domain.User;
import com.example.sem3hw2.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    //region Поля
    private DataProcessingService service;
    //endregion

    /**
     * Возвращает задания, которые можно использовать с списком юзеров
     * @return Список заданий
     */
    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Сортирует юзеров по возрасту
     * @return Отсортированный список
     */
    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getListOfUsers());
    }

    /**
     * Фильтруют юзеров по возрасту(больше чем указанный возраст)
     * @param age возраст, старше которого хотим отфильтровать
     * @return список юзеров, подходящих по фильтрации
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age){
        return service.filterUsersByAge(service.getListOfUsers(), age);
    }

    /**
     * Средний возраст всех юзеров
     * @return средний возраст
     */
    @GetMapping("/calc")
    public Double calculateAverageAge(){
        return service.calculateAverageAge(service.getListOfUsers());
    }

    //region Конструкторы
    public TaskController(DataProcessingService service) {
        this.service = service;
    }
    //endregion
}
