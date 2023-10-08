package com.oracle;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@ComponentScan(basePackages = "com.oracle")
@EnableScheduling
public class FinanceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceAppApplication.class, args);
		
	}
	
	
}
