package com.microservice.celulares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServicesCelularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicesCelularApplication.class, args);
	}

}
