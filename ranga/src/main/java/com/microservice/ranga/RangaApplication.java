package com.microservice.ranga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RangaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RangaApplication.class, args);
	}

}
