package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter05Application {

	public static void main(String[] args) {
//		SpringApplication.run(Chapter05Application.class, args);
		SpringApplication application = new SpringApplication(Chapter05Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
