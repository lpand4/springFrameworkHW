package com.example.hwSem7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    /**
     * Страница аутентификации
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    /**
     * Страница с приватными данными
     * @return
     */
    @GetMapping("/private")
    public String privateData() {
        return "private.html";
    }

    /**
     * Публичная страница
     * @return
     */
    @GetMapping("/public")
    public String publicData() {
        return "public.html";
    }
}
