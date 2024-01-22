package com.example.sem3hw.controllers;

import com.example.sem3hw.domain.User;
import com.example.sem3hw.services.RegistrationService;
import com.example.sem3hw.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private RegistrationService service;


    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getListOfUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.processRegistration(user);
        return "User added from body!";
    }








    public UserController(RegistrationService service) {
        this.service = service;
    }
}
