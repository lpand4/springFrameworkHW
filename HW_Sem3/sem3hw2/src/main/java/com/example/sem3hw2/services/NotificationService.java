package com.example.sem3hw2.services;

import com.example.sem3hw2.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    /**
     * Сообщение в консоль о создании нового юзера
     * @param user новый юзер
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Отправка любого сообщения в консоль
     * @param s сообщение
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
