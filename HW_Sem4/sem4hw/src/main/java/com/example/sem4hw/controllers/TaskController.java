package com.example.sem4hw.controllers;

import com.example.sem4hw.domain.Task;
import com.example.sem4hw.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Основной контроллер дневника заданий
 */
@Controller
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    TaskService service;

    /**
     * Список заданий(добавляет 2 задачи для наглядности)
     * @param model
     * @return
     */
    @GetMapping
    public String tasks(Model model){
        if (service.getAll().isEmpty()) {
            service.addTask(new Task(null,"Домашнее задание", "Сделать домашнее задание до 20:00"));
            service.addTask(new Task(null,"Приготовить еду", "Приготовить еду до 17:00"));
        }
        model.addAttribute("tasks", service.getAll());
        model.addAttribute("count", service.getAll().size());
        return "tasks";
    }

    /**
     * Страница создания новой задачи
     * @return
     */
    @GetMapping("/new")
    public String createTask(){
        return "newTask";
    }

    /**
     * Отправляет новую задачу в базу
     * @param task новая задача
     * @return
     */
    @PostMapping("/new")
    public String addTask(Task task){
        service.addTask(task);
        return "redirect:/tasks";
    }

    /**
     * Удаление задачи по айди
     * @param id айди необходимой задачи
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return "redirect:/tasks";
    }

    /**
     * Обновление задачи по айди
     * @param id айди необходимой задачи
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, Model model) {
        Task task = service.getOne(id);
        model.addAttribute(task);
        return "updateTask";
    }

    /**
     * Обновляет задачу и отправляет в базу
     * @param task новый данные задачи
     * @return
     */
    @PostMapping("/update")
    public String updateTask(Task task){
        service.updateTask(task);
        return "redirect:/tasks";
    }
}
