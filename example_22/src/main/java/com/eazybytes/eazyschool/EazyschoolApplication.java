package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class EazyschoolApplication {

	public static void main(String[] args) {

		SpringApplication.run(EazyschoolApplication.class, args);
	}
}
