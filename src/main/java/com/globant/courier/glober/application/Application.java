package com.globant.courier.glober.application;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.globant.courier.glober.infrastructure.repositories.jpa")
@EntityScan("com.globant.courier.glober.infrastructure.entities")
@ComponentScan("com.globant.courier.glober")
public class Application {

	@Generated
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
