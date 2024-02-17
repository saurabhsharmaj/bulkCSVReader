package com.example.merter.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.merter.vo.CsvContants;
import com.example.merter.vo.CsvRecord;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CsvReaderService {
	
	@Autowired
	ChunkProcessor chunkProcessor;
	
	private final String filePath;
    private final int chunkSize;

    public CsvReaderService() {
        this.filePath = CsvContants.CSV_FILE_NAME;
        this.chunkSize = CsvContants.CHUNK_SIZE;
    }

    public void readInChunks(File file) throws IOException, CsvValidationException {
    	  try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            CsvToBeanBuilder<CsvRecord> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CsvRecord.class);

            List<CsvRecord> chunk;
            do {
                chunk = csvToBeanBuilder.build().parse();
                if (!chunk.isEmpty()) {
                    chunkProcessor.processChunk(chunk);
                }
            } while (!chunk.isEmpty());
        }
    }
    
    public List<CsvRecord> readCsvFile(String filePath) throws FileNotFoundException {
    	File file = ResourceUtils.getFile("classpath:"+filePath);
        try (Reader reader = Files.newBufferedReader(file.toPath());
             CSVReader csvReader = new CSVReader(reader)) {
        	
        	
        			        
            CsvToBean<CsvRecord> csvToBean = new CsvToBeanBuilder<CsvRecord>(csvReader)
                    .withType(CsvRecord.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    
                    .build();

            return csvToBean.parse();

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return null;
        }
    }
}