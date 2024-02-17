package com.example.merter.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.merter.service.CsvReaderService;

@Component
public class FileReadScheduler {

	private static String fileName = "meter_values_dump_10k.csv";
	@Autowired
	private CsvReaderService csvReaderService;

	@Scheduled(fixedRate = 600000) // 600,000 milliseconds = 10 minutes
	public void runScheduledTask() {

		try {
			csvReaderService.readInChunks();
			System.out.println("Scheduled task executed at: " + System.currentTimeMillis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
