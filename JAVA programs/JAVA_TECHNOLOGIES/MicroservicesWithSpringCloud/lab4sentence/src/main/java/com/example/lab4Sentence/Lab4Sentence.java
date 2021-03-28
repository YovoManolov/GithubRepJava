package com.example.lab4Sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Lab4Sentence {

	public static void main(String[] args) {
		SpringApplication.run(Lab4Sentence.class, args);
	}

}
