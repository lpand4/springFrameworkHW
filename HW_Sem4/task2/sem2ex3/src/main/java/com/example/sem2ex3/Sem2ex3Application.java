package com.example.sem2ex3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Sem2ex3Application {

	public static void main(String[] args) {
		log.info("App is started!");
		SpringApplication.run(Sem2ex3Application.class, args);
	}

}
