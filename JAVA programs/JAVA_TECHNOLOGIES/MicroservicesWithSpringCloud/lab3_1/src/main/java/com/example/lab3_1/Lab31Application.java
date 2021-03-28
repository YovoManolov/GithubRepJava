package com.example.lab3_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Lab31Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab31Application.class, args);
	}

}
