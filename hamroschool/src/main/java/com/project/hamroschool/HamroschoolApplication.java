package com.project.hamroschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.hamroschool.repository")
@EntityScan("com.project.hamroschool.model")
public class  HamroschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamroschoolApplication.class, args);
	}
}
