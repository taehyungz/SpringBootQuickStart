package com.rubypaper.Chapter01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rubypaper", "com.ruby"})
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
	}

}
