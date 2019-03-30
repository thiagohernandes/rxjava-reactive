package com.reactive.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.reactive.controller", "com.reactive"})
@EntityScan("com.reactive.model")
@EnableJpaRepositories("com.reactive.repository")
public class ReactiveBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBasicApplication.class, args);
	}

}
