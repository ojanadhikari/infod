package com.infodev.fpro.controller;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infodev.fpro.repository.DataRepository;
import com.infodev.fpro.dto.DataCreationDto;
import com.infodev.fpro.model.Data;

@CrossOrigin
@RestController
public class DataController {

	@Autowired
	DataRepository dataRepository;
	
	@RequestMapping (value="/data", method = RequestMethod.GET)
	public  List<Data>getAllData()
	{
		return dataRepository.findAll();
	
	}
	
	@RequestMapping (value="/data/{id}", method = RequestMethod.GET)
	public Data getData(@PathVariable("id") int id) 
	{
		return dataRepository.findById((long) id).get();
	}
	
	@RequestMapping (value="/data", method = RequestMethod.POST)
	public Data createData(DataCreationDto dataCreationDto)
	{
		Data data =new Data();
		data.setAddress(dataCreationDto.getAddress());
		data.setCheckedInDate(new Date());
		data.setFullName(dataCreationDto.getFullName());
		data.setSerialNumber(dataCreationDto.getSerialNumber());
		data.setTemperature(dataCreationDto.getTemperature());
		return dataRepository.save(data);
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
