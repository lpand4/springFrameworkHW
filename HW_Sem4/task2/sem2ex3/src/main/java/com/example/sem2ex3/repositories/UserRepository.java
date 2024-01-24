package com.example.sem2ex3.repositories;

import com.example.sem2ex3.model.MagicDataRequest;
import com.example.sem2ex3.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    private MagicDataRequest mdr;

    /**
     * Поиск всех пользователей в базе
     * @return Список пользователей
     */
    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(mdr.getSelectAll(), userRowMapper);
    }

    /**
     * Сохранение нового пользователя в базу
     * @param user новый пользователь
     * @return
     */
    public User save(User user) {
        jdbc.update(mdr.getSaveUser(), user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаление пользователя по айди
     * @param id айди необходимого пользователя
     */
    public void deleteById(int id) {
        jdbc.update(mdr.getDeleteUser(), id);
    }

    /**
     * Обновление пользователя
     * @param user новый пользователь
     * @return
     */
    public User updateById(User user) {
        jdbc.update(mdr.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
        return getOne(user.getId());
    }

    /**
     * Поиск пользователя по айди
     * @param id айди необходимого пользователя
     * @return
     */
    public User getOne(int id) {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(mdr.getSelectUser(), new Object[]{id}, userRowMapper);
    }
}
