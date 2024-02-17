package com.example.merter.schedular;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.example.merter.common.CsvUtils;
import com.example.merter.service.CsvReaderService;
import com.example.merter.vo.CsvContants;

@Component
public class FileReadScheduler {

	private static String fileName = "meter_values_dump_10k.csv";
	@Autowired
	private CsvReaderService csvReaderService;

	@Autowired
	CsvUtils csvUtils;
	
	//@Scheduled(fixedRate = 600000) // 600,000 milliseconds = 10 minutes
	public void runScheduledTask() {

		try {
			File file = ResourceUtils.getFile("classpath:"+CsvContants.CSV_FILE_NAME);
			csvUtils.changeExtension(file, CsvContants.READ_INPROGESS);
			csvReaderService.readInChunks(file);
			System.out.println("Scheduled task executed at: " + System.currentTimeMillis());
			csvUtils.changeExtension(file, CsvContants.READ_COMPLETED);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
