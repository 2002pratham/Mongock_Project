package com.example.demo;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongock
@SpringBootApplication
public class MongockLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongockLearningApplication.class, args);
	}

}
