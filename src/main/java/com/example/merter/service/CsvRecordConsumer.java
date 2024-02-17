package com.example.merter.service;

import com.example.merter.vo.CsvRecord;
import com.example.merter.vo.DataQueue;

public class CsvRecordConsumer implements Runnable {
    private boolean running = false;
    private final DataQueue dataQueue;

    public CsvRecordConsumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        running = true;
        consume();
    }

    public void stop() {
        running = false;
    }

    public void consume() {
        while (running) {

            if (dataQueue.isEmpty()) {
                try {
                    dataQueue.waitIsNotEmpty();
                } catch (InterruptedException e) {
                    break;
                }
            }

            // avoid spurious wake-up
            if (!running) {
                break;
            }

            CsvRecord csvRecord = dataQueue.poll();
            useCsvRecord(csvRecord);

            //Sleeping on random time to make it realistic
           try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
       
    }

    private void useCsvRecord(CsvRecord csvRecord) {
        if (csvRecord != null) {
           //save csvRecord to db.
        	System.out.println("csvRecord consumed:" +csvRecord);
        }
    }

}