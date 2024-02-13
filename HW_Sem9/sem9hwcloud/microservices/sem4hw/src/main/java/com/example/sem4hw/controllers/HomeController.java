package com.example.sem4hw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер начальной страницы(Задание 1)
 */
@Controller
@RequestMapping("/serviceA")
public class HomeController {
    /**
     * Начальная страница без использования шаблонизатора
     * @return
     */
    @GetMapping
    public String home(){
        return "home.html";
    }

    @GetMapping("/")
    public String homeAgain(){
        return "home.html";
    }
}
