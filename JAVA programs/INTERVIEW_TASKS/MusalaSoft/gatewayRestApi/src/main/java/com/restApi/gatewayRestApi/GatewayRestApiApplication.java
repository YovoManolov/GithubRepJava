package com.restApi.gatewayRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GatewayRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayRestApiApplication.class, args);
	}

}
