package com.example.sem4hw.repositories;

import com.example.sem4hw.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class TaskRepository {

    JdbcTemplate jdbc;

    public List<Task> getAll(){
        String sql = "SELECT * FROM tasksTable";
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task(r.getLong("id"),
                    r.getString("name"),
                    r.getString("description"));
            return rowObject;
        };
        return jdbc.query(sql, taskRowMapper);
    }


    public Task addTask(Task task) {
        String sql = "INSERT INTO tasksTable VALUES (DEFAULT, ?, ?)";
        jdbc.update(sql, task.getName(), task.getDescription());
        return task;
    }

    public void deleteTask(Long id) {
        String sql = "DELETE FROM tasksTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public Task updateTask(Task task) {
        String sql = "UPDATE tasksTable SET name=?, description=? WHERE id=?";
        jdbc.update(sql, task.getName(), task.getDescription(), task.getId());
        return getOne(task.getId());
    }

    public Task getOne(Long id) {
        String sql = "SELECT * FROM tasksTable WHERE id=?";
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task(r.getLong("id"),
                    r.getString("name"),
                    r.getString("description"));
            return rowObject;
        };
        return jdbc.queryForObject(sql, new Object[]{id}, taskRowMapper);
    }
}
