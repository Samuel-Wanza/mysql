package com.example.simSwapping;

import org.springframework.boot.SpringApplication;

public class TestAccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.from(simSwappingApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
