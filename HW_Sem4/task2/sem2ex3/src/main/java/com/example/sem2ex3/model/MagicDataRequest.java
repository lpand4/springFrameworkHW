package com.example.sem2ex3.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

/**
 * Конфигуратор SQL запросов
 */
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "requests")
@Data
@Component
public class MagicDataRequest {
    private String selectAll;
    private String selectUser;
    private String saveUser;
    private String deleteUser;
    private String updateUser;
}
