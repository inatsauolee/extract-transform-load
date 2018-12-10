package com.ensah.etl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ensah.etl.spark.SparkService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FileController {

	@Autowired
	SparkService sparkService;
	
	@GetMapping("/fileHeaders")
	public ResponseEntity<String[]> getFileHeaders(String fileName) {
		return new ResponseEntity<String[]>(sparkService.getHeaders(fileName), HttpStatus.OK);
	}
	
	@GetMapping("/allFiles")
	public ResponseEntity<List<String>> allFiles() {
		return new ResponseEntity<List<String>>(sparkService.getFiles(), HttpStatus.OK);
	}
	

}