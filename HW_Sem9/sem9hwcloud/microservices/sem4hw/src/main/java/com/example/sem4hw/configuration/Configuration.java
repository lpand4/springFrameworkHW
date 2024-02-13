package com.example.sem4hw.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("task-microservice")
@org.springframework.context.annotation.Configuration
@Data
public class Configuration {
    private String selectAll;
    private String selectTask;
    private String saveTask;
    private String deleteTask;
    private String updateTask;
}
