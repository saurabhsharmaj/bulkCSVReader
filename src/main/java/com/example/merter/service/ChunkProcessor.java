package com.example.merter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.merter.vo.CsvRecord;

@Service
public class ChunkProcessor {

    public void processChunk(List<CsvRecord> chunk) {
        // Process each chunk as needed
    	System.out.println(chunk.size());
        for (CsvRecord record : chunk) {
        	//System.err.println(record);
            // Record push into Queue.
        }
    }
}
