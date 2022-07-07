package com.ctsproject;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.ctsproject"})
public class UrlshorteningserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlshorteningserviceApplication.class, args);
		System.out.println("URL Project");
	}
	

}
