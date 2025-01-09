package com.example.hello_world;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@EntityScan(basePackages = {"com.example"})
@ComponentScan(basePackages = {"com.example"})
@EnableJpaRepositories(basePackages = {"com.example"})
@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Merhaba Dünya!");
	}
}