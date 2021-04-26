package io.github.PatrickZerbinatti.apiv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ApiV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiV1Application.class, args);
	}

}
