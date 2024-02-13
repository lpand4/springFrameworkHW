package com.example.sem9hwcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sem9hwcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem9hwcloudApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("TaskMicroservice",r->r.path("/serviceA/**")
						.uri("http://localhost:8081/"))
				.route("RickAndMortyMicroservice",r->r.path("/serviceB/**")
						.uri("http://localhost:8082/")).build();}

}
