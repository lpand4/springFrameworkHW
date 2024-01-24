package com.example.sem2ex3.controllers;


import com.example.sem2ex3.model.User;
import com.example.sem2ex3.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {

    private final UserService userService;

    /**
     * Вывод всех пользователей на экран
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("Пользователи выведены на экран");
        return "user-list";
    }

    /**
     * Создание нового пользователя
     * @param user Новый пользователь
     * @return
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /**
     * Сохранение созданного пользователя в базу
     * @param user новый пользователь
     * @return
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        User createdUser = userService.saveUser(user);
        log.info("Пользователь " + createdUser.getId() +" был сохранен");
        return "redirect:/users";
    }

    /**
     * Удаление пользователя
     * @param id айди нужного пользователя
     * @return
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        log.info("Пользователь " + id +" был удален");
        return "redirect:/users";
    }

    /**
     * Обновление пользователя
     * @param id айди нужного пользователя
     * @param model
     * @return
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable int id, Model model) {
        User user = userService.getOne(id);
        model.addAttribute(user);
        log.info("Пользователь " + user.getId() +" выведен для обновления");
        return "user-update";
    }

    /**
     * Отправка новых данных об обновленном пользователе
     * @param user новые данные
     * @return
     */
    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        log.info("Пользователь " + user.getId() +" был обновлен");
        return "redirect:/users";
    }
}
