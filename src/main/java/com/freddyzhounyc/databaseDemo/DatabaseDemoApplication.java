package com.freddyzhounyc.databaseDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DatabaseDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}
}