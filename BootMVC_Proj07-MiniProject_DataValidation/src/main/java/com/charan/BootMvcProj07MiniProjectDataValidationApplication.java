package com.charan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BootMvcProj07MiniProjectDataValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj07MiniProjectDataValidationApplication.class, args);
		log.info("Application Started");
	}

}
