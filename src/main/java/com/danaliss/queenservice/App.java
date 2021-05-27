package com.danaliss.queenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.danaliss.queenservice.*")
@EntityScan("com.danaliss.queenservice.*")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
