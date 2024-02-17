package com.example.merter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.merter.vo.CsvRecord;

@Service
public class ChunkProcessor {

    public void processChunk(List<CsvRecord> chunk) {
        // Process each chunk as needed
        for (CsvRecord record : chunk) {
            // Record push into Queue.
        }
    }
}
