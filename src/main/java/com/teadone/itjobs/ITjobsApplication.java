package com.teadone.itjobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ITjobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ITjobsApplication.class, args);
	}

}
