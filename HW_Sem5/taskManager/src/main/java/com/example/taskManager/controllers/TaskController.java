package com.example.taskManager.controllers;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.TaskStatus;
import com.example.taskManager.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
    /**
     * Сервис связующий репозиторий с контроллером
     */
    private TaskService taskService;

    /**
     * Добавление задачи
     * @param task новая задача
     * @return добавленная задача
     */
    @PostMapping("/new")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    /**
     * Получение списка всех задач
     * @return список задач
     */
    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }
    /**
     * Поиск задач по статусу
     * @param status искомый статус
     * @return список задач с искомым статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.findTasksByStatus(status);
    }
    /**
     * Изменение статуса задачи
     * @param id айди задачи
     * @param task задача с новым статусом
     * @return измененная задача
     */
    @PutMapping("/{id}")
    public Optional<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.changeStatusOfTask(id, task.getStatus());
    }
    /**
     * Удаление задачи по айди
     * @param id айди задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
