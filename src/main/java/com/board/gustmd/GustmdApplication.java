package com.board.gustmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class GustmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(GustmdApplication.class, args);
	}

}
