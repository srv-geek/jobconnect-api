package com.srvgeek.jobboardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobBoardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobBoardApiApplication.class, args);
		System.out.println("Application is Started...");
	}

}
