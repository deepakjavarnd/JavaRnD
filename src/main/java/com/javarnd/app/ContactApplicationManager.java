package com.javarnd.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ContactApplicationManager {

	public static void main(String[] args) {
		SpringApplication.run(ContactApplicationManager.class, args);
	}
}
