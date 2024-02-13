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

    /**
     * Получение списка задач
     * @return список задач
     */
    public List<Task> getAll(){
        return repository.getAll();
    }

    /**
     * Добавление задачи в базу
     * @param task новая задача
     * @return
     */
    public Task addTask(Task task){
        return repository.addTask(task);
    }
    /**
     * Удаление задачи по айди
     * @param id айди необходимой задачи
     */
    public void deleteTask(Long id) {
        repository.deleteTask(id);
    }
    /**
     * Обновление задачи по айди
     * @param task Новые данные
     * @return
     */
    public Task updateTask(Task task){
        return repository.updateTask(task);
    }
    /**
     * Получение задачи по айди
     * @param id айди необходимой задачи
     * @return необходимая задача
     */
    public Task getOne(Long id){
        return repository.getOne(id);
    }
}
