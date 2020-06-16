package com.jbk.ApiController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jbk")
public class ApiWithJunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWithJunitApplication.class, args);
	}

}
