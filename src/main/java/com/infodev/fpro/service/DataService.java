package com.infodev.fpro.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infodev.fpro.dto.DataCreationDto;
import com.infodev.fpro.model.Data;
import com.infodev.fpro.repository.DataRepository;

@Service
public class DataService {
	
	@Autowired	
	DataRepository dataRepository;
	
	public Data addData(DataCreationDto dataCreationDto) {
		Data data=new Data();
		data.setAddress(dataCreationDto.getAddress());
		data.setCheckedInDate(new Date());
		data.setFullName(dataCreationDto.getFullName());
		data.setSerialNumber(dataCreationDto.getSerialNumber());
		data.setTemperature(dataCreationDto.getTemperature());
		
		return dataRepository.save(data);
	}
	
	public List<Data> listAllData(){
		return dataRepository.findAll();
				
	}
}
