package com.example.sem4hw.repositories;

import com.example.sem4hw.configuration.Configuration;
import com.example.sem4hw.domain.Task;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TaskRepository {

    JdbcTemplate jdbc;
    Configuration dr;

    /**
     * Получение списка задач
     * @return список задач
     */
    public List<Task> getAll(){
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task(r.getLong("id"),
                    r.getString("name"),
                    r.getString("description"));
            return rowObject;
        };
        return jdbc.query(dr.getSelectAll(), taskRowMapper);
    }

    /**
     * Добавление задачи в базу
     * @param task новая задача
     * @return
     */
    public Task addTask(Task task) {
        jdbc.update(dr.getSaveTask(), task.getName(), task.getDescription());
        return task;
    }

    /**
     * Удаление задачи по айди
     * @param id айди необходимой задачи
     */
    public void deleteTask(Long id) {
        jdbc.update(dr.getDeleteTask(), id);
    }

    /**
     * Обновление задачи по айди
     * @param task Новые данные
     * @return
     */
    public Task updateTask(Task task) {
        jdbc.update(dr.getUpdateTask(), task.getName(), task.getDescription(), task.getId());
        return getOne(task.getId());
    }

    /**
     * Получение задачи по айди
     * @param id айди необходимой задачи
     * @return необходимая задача
     */
    public Task getOne(Long id) {
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task(r.getLong("id"),
                    r.getString("name"),
                    r.getString("description"));
            return rowObject;
        };
        return jdbc.queryForObject(dr.getSelectTask(), new Object[]{id}, taskRowMapper);
    }
}
