package com.example.sem9hweureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sem9hwEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem9hwEurekaApplication.class, args);
	}

}
