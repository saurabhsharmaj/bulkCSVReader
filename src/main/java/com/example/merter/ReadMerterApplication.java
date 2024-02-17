package com.example.merter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 
 * @author Lenovo
 *
 */
@EnableScheduling
@SpringBootApplication
public class ReadMerterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadMerterApplication.class, args);
	}

}
