package com.example.merter.service;

import java.util.concurrent.atomic.AtomicInteger;

import com.example.merter.vo.CsvRecord;
import com.example.merter.vo.DataQueue;

public class CsvRecordProducer implements Runnable {
    private static final AtomicInteger idSequence = new AtomicInteger(0);
    private boolean running = false;
    private final DataQueue dataQueue;

    public CsvRecordProducer(DataQueue dataQueue) {
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

            dataQueue.add(generateMessage());

           

            //Sleeping on random time to make it realistic
           try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }

        
    }

    private CsvRecord generateMessage() {
       

        return null;
    }

}
