package com.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = {"com.yash.domain"})
public class CbsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CbsApplication.class, args);
	}
	
}
