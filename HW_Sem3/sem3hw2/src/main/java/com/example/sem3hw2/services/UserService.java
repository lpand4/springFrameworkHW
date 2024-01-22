package com.example.sem3hw2.services;

import com.example.sem3hw2.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //region Поля
    private NotificationService notificationService;
    //endregion

    //region Конструкторы
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    //endregion

    /**
     * Создание юзера
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return новый юзер
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

    /**
     * Перегрузка создания юзера
     * @param user новый юзер
     * @return новый юзер
     */
    public User createUser(User user) {
        return createUser(user.getName(), user.getAge(), user.getEmail());
    }
}
