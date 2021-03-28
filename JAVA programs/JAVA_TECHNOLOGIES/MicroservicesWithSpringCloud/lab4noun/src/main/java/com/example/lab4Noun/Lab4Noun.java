package com.example.lab4Noun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Lab4Noun {

	public static void main(String[] args) {
		SpringApplication.run(Lab4Noun.class, args);
	}

}
