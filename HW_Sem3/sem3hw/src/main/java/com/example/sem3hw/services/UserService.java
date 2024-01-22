package com.example.sem3hw.services;

import com.example.sem3hw.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private NotificationService notificationService;

    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

    public User createUser(User user) {
        return createUser(user.getName(), user.getAge(), user.getEmail());
    }
}
