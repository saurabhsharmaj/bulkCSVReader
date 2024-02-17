package com.example.merter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.merter.common.CsvUtils;
/**
 * 
 * @author Lenovo
 *
 */
@EnableScheduling
@SpringBootApplication
public class ReadMerterApplication {

	@Autowired
	CsvUtils csvUtils;
	
	public static void main(String[] args) {
		SpringApplication.run(ReadMerterApplication.class, args);
	}

	@PostConstruct
	public void init() {
		csvUtils.startMultipleProducersAndMultipleConsumers();
	}
	
	@PreDestroy
	public void stop() {
		csvUtils.stopMultipleProducersAndMultipleConsumers();
	}
}
