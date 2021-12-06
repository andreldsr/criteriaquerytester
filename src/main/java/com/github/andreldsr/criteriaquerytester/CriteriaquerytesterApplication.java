package com.github.andreldsr.criteriaquerytester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.github.andreldsr.criteriaquerytester")
@EnableJpaRepositories("com.github.andreldsr.criteriaquerytester")
public class CriteriaquerytesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriteriaquerytesterApplication.class, args);
	}

}
