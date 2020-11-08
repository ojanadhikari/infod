package com.infodev.fpro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infodev.fpro.repository.DataRepository;
import com.infodev.fpro.service.DataService;
import com.infodev.fpro.dto.DataCreationDto;
import com.infodev.fpro.model.Data;

@CrossOrigin
@RestController
public class DataController {

	@Autowired
	DataRepository dataRepository;
	
	@Autowired
	DataService dataService;
	
	
	@RequestMapping (value="/data", method = RequestMethod.GET)
	public  ResponseEntity<Object> listAllData(){
		List<Data> data=dataService.listAllData();
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	
	}
	
	@RequestMapping (value="/data/{id}", method = RequestMethod.GET)
	public Data getData(@PathVariable("id") int id) 
	{
		return dataRepository.findById((long) id).get();
	}
	
	@RequestMapping (value="/data", method = RequestMethod.POST)
	public ResponseEntity<Object> createData(DataCreationDto dataCreationDto)
	{
		dataService.addData(dataCreationDto);
		return new ResponseEntity<Object>("Data Added Successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping (value="/data", method = RequestMethod.PUT)
	public Data updateData(Data data)
	{
		return dataRepository.save(data);
	}
	
	@RequestMapping (value="/data/{id}", method = RequestMethod.DELETE)
	
	public void deleteData(@PathVariable("id") int id)
	{
		dataRepository.deleteById((long) id);
	}
	
}
