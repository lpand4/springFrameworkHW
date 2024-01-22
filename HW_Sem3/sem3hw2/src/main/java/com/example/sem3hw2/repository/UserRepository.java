package com.example.sem3hw2.repository;

import com.example.sem3hw2.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    //region Поля
    private final JdbcTemplate jdbc;
    //endregion
    //region Конструкторы
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    //endregion

    /**
     * Получение всех добавленных юзеров
     * @return список юзеров
     */
    public List<User> getAll(){
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Добавление юзера
     * @param user новый юзер
     */
    public void addUser(User user){
        String sql = "INSERT INTO userTable VALUES (DEFAULT, ?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
