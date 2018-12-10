package com.ensah.etl.controller;

import java.util.List;

import org.apache.spark.sql.AnalysisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensah.etl.bean.GroupByQuery;
import com.ensah.etl.spark.SparkService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransformationController {

	@Autowired
	SparkService sparkService;
	

	@GetMapping("/select")
	public ResponseEntity<List<String>> select(String fileName, String query) throws AnalysisException {
		return new ResponseEntity<List<String>>(sparkService.select(fileName, query), HttpStatus.OK);
	}
	
	@PostMapping("/groupby")
	public ResponseEntity<List<String>> groupBy(@RequestBody GroupByQuery query, String fileName) throws AnalysisException {
		return new ResponseEntity<List<String>>(sparkService.groupBy(fileName, query.getAggregations(), query.getGroupByClos()), HttpStatus.OK);
	}
	
	@GetMapping("/combine")
	public ResponseEntity<List<String>> combine(String file1, String file2, String query) throws AnalysisException {
		return new ResponseEntity<List<String>>(sparkService.combine(file1, file2, query), HttpStatus.OK);
	}
	
	
}