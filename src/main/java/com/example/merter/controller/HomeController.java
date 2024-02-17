package com.example.merter.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.merter.service.CsvReaderService;
import com.example.merter.vo.CsvRecord;
import com.example.merter.vo.Response;
import com.example.merter.vo.ResponseBuilder;

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
	 */
	@GetMapping(path = "/read")
	public ResponseEntity<Response> readcsv() throws IOException {
		String fileName="meter_values_dump_10k.csv";
		List<CsvRecord> records = csvReaderService.readCsvFile(fileName);

		Response res = new ResponseBuilder().setData(records).setError(false).setMessage(HttpStatus.OK.toString())
				.build();
		return ResponseEntity.ok(res);
	}
}
