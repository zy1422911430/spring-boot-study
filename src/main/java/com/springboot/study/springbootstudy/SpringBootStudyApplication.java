package com.springboot.study.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.study")
public class SpringBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootStudyApplication.class);
		application.setAdditionalProfiles("prod");
		application.run(args);
	}
}
