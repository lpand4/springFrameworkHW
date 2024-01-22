package com.example.sem3hw2.controllers;

import com.example.sem3hw2.domain.User;
import com.example.sem3hw2.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //region Поля
    private RegistrationService service;
    //endregion
    /**
     * Список всех добавленных юзеров
     * @return Список юзеров
     */
    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getListOfUsers();
    }

    /**
     * Добавление юзера через тело запроса
     * @param user Новый юзер
     * @return Ответ, что пользователь добавлен
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.processRegistration(user);
        return "User added from body!";
    }

    //В классе UserController добавить обработчик userAddFromParam
    //извлекающий данные для создания пользователя из параметров HTTP запроса

    /**
     * Добавление юзера через параметры HTTP запроса
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return Ответ, что пользователь добавлен
     */
    @GetMapping("/param")
    public String userAddFromParam(@RequestParam String name,@RequestParam int age,@RequestParam String email){
        service.processRegistration(name,age,email);
        return "User added from param!";
    }
    //region Конструкторы
    public UserController(RegistrationService service) {
        this.service = service;
    }
    //endregion
}
