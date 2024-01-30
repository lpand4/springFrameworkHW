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
    /**
     * Репозиторий хранения задач
     */
    private TaskRepository repository;

    /**
     * Добавление задачи
     * @param task новая задача
     * @return добавленная задача
     */
    public Task addTask(Task task) {
        return repository.save(task);
    }

    /**
     * Получение списка всех задач
     * @return список задач
     */
    public List<Task> getAllTask() {
        return repository.findAll();
    }

    /**
     * Изменение статуса задачи
     * @param id айди задачи
     * @param newStatus новый статус этой задачи
     * @return измененная задача
     */
    @Transactional
    public Optional<Task> changeStatusOfTask(Long id, TaskStatus newStatus) {
        repository.changeStatus(id, newStatus);
        return repository.findById(id);
    }

    /**
     * Удаление задачи по айди
     * @param id айди задачи
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    /**
     * Поиск задач по статусу
     * @param status искомый статус
     * @return список задач с искомым статусом
     */
    public List<Task> findTasksByStatus(TaskStatus status){
        return repository.findAllByStatus(status);
    }
}
