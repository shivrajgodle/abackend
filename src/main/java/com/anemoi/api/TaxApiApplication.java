package com.anemoi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaxApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxApiApplication.class, args);
		System.out.println("hello world");
		System.out.println("trying to push");
		System.out.println("hello shiv");
		
	}
}
