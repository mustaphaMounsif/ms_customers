package com.ensa.mscustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MsCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomersApplication.class, args);
		
	}
	

}
