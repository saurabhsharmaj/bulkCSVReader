package com.example.merter.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.merter.service.CsvReaderService;
import com.example.merter.vo.CsvContants;
import com.example.merter.vo.CsvRecord;
import com.example.merter.vo.Response;
import com.example.merter.vo.ResponseBuilder;
import com.opencsv.exceptions.CsvValidationException;

/**
 * 
 * @author Lenovo
 *
 */
@RestController
public class HomeController {

	@Autowired
	private CsvReaderService csvReaderService;

	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws CsvValidationException 
	 */
	@GetMapping(path = "/read")
	public ResponseEntity<Response> readcsv() throws IOException, CsvValidationException {
		
		List<CsvRecord> records = csvReaderService.readCsvFile(CsvContants.CSV_FILE_NAME);

		Response res = new ResponseBuilder().setData(records).setError(false).setMessage(HttpStatus.OK.toString())
				.build();
		return ResponseEntity.ok(res);
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws CsvValidationException 
	 */
	@GetMapping(path = "/read/{id}")
	public ResponseEntity<Response> readcsv(@PathVariable String id) throws IOException, CsvValidationException {
		
		Optional<CsvRecord> record = csvReaderService.readCsvFile(CsvContants.CSV_FILE_NAME).stream().filter(csv->csv.getChargePointId().equals(id)).findFirst();

		Response res = new ResponseBuilder().setData(record).setError(false).setMessage(HttpStatus.OK.toString())
				.build();
		return ResponseEntity.ok(res);
	}
}
