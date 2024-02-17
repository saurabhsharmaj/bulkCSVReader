package com.example.merter.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.merter.vo.CsvContants;
import com.example.merter.vo.CsvRecord;
import com.example.merter.vo.DataQueue;

public class CsvRecordProducer implements Runnable {

	private static final AtomicInteger idSequence = new AtomicInteger(0);
	private boolean running = false;
	private final DataQueue dataQueue;
	private CsvReaderService csvReaderService;

	public CsvRecordProducer(CsvReaderService csvReaderService, DataQueue dataQueue) {
		this.csvReaderService = csvReaderService;
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		running = true;
		produce();
	}

	public void stop() {
		running = false;
	}

	public void produce() {

		while (running) {

			if (dataQueue.isFull()) {
				try {
					dataQueue.waitIsNotFull();
				} catch (InterruptedException e) {

					break;
				}
			}

			// avoid spurious wake-up
			if (!running) {
				break;
			}
			try {
				List<CsvRecord> csvRecords = csvReaderService.readCsvFile(CsvContants.CSV_FILE_NAME);
				csvRecords.stream().forEach(csvRecord -> {
					dataQueue.add(csvRecord);
					System.out.println("record pushed: "+csvRecord);
				});
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Sleeping on random time to make it realistic
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
