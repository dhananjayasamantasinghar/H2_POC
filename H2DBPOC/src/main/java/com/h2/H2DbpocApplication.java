package com.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.h2.*")
public class H2DbpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DbpocApplication.class, args);
	}

}
