package com.example.mito.Java17FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Java17FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java17FinalProjectApplication.class, args);
	}

}
