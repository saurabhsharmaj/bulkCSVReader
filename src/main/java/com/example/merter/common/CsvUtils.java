package com.example.merter.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.merter.service.CsvReaderService;
import com.example.merter.service.CsvRecordConsumer;
import com.example.merter.service.CsvRecordProducer;
import com.example.merter.vo.CsvContants;
import com.example.merter.vo.DataQueue;

@Component
public class CsvUtils extends ThreadUtil {

	@Autowired
	CsvReaderService csvReaderService;
	
	 DataQueue dataQueue = new DataQueue(CsvContants.MAX_QUEUE_CAPACITY);
     int producerCount = CsvContants.PRODUCER_COUNT;
     int consumerCount = CsvContants.CONSUMER_COUNT;
     List<Thread> threads = new ArrayList<>();
     List<CsvRecordProducer> producers = new ArrayList<>();
     List<CsvRecordConsumer> consumers = new ArrayList<>();
     
	public File changeExtension(File f, String newExtension) {
		  int i = f.getName().lastIndexOf('.');
		  String name = f.getName().substring(0,i);
		  return new File(f.getParent(), name + newExtension);
		}

	public void startMultipleProducersAndMultipleConsumers() {
		for(int i = 0; i < producerCount; i++) {
			CsvRecordProducer producer = new CsvRecordProducer(csvReaderService, dataQueue);
            Thread producerThread = new Thread(producer);
            producerThread.start();
            threads.add(producerThread);
            producers.add(producer);
        }

        for(int i = 0; i < consumerCount; i++) {
        	CsvRecordConsumer consumer = new CsvRecordConsumer(dataQueue);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
            threads.add(consumerThread);
            consumers.add(consumer);
        }
		
	}

	public void stopMultipleProducersAndMultipleConsumers() {
		consumers.forEach(CsvRecordConsumer::stop);
        producers.forEach(CsvRecordProducer::stop);

        waitForAllThreadsToComplete(threads);
		
	}
}
