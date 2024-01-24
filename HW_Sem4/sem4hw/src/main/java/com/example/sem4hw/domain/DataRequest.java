package com.example.sem4hw.domain;

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
public class DataRequest {
    private String selectAll;
    private String selectTask;
    private String saveTask;
    private String deleteTask;
    private String updateTask;
}
