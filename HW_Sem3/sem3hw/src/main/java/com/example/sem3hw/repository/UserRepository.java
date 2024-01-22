package com.example.sem3hw.repository;

import com.example.sem3hw.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    //region Поля
    private List<User> users = new ArrayList<>();
    //endregion

    //region Вспомогательные методы
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    //endregion
}
