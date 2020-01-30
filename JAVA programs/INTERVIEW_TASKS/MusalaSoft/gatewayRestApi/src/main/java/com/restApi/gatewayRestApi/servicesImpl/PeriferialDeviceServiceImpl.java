package com.restApi.gatewayRestApi.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;
import com.restApi.gatewayRestApi.repository.PeriferialDeviceRepository;
import com.restApi.gatewayRestApi.services.PeriferialDeviceServiceI;



@Service
public class PeriferialDeviceServiceImpl implements PeriferialDeviceServiceI {
	
	@Autowired
	PeriferialDeviceRepository periferialDeviceRepository;

	@Override
	public List<PeriferialDevice> getAllPeriferialDevices() {
		
		List<PeriferialDevice> periferialDeviceList = periferialDeviceRepository.findAll();
		
        if(periferialDeviceList.size() > 0) {
            return periferialDeviceList;
        } else {
            return new ArrayList<PeriferialDevice>();
        }
	}

	@Override
	public PeriferialDevice getPeriferialDeviceById(Long periferialDeviceId) throws RecordNotFoundException {
		
	    Optional<PeriferialDevice> periferialDevice =  periferialDeviceRepository.findById(periferialDeviceId);
	    
	    if(periferialDevice.isPresent()) {
            return periferialDevice.get();
        } else {
            throw new RecordNotFoundException("No periferialDevice record exist for given id");
        }
	}

	@Override
	public PeriferialDevice createOrUpdatePeriferialDevice(PeriferialDevice periferialDevice) throws RecordNotFoundException {
		 
	        Optional<PeriferialDevice> periferialDeviceOptional =
	        				periferialDeviceRepository.findById(periferialDevice.getId());
	         
	        if(periferialDeviceOptional.isPresent()) 
	        {
	            PeriferialDevice periferialDeviceUpdated = periferialDeviceOptional.get();
	            periferialDeviceUpdated.setId(periferialDevice.getId()); 
	            periferialDeviceUpdated.setDateCreated(periferialDevice.getDateCreated()); 
	            periferialDeviceUpdated.setGateway(periferialDevice.getGateway()); 
	            periferialDeviceUpdated.setStatus(periferialDevice.getStatus()); 
	            
	            periferialDeviceUpdated = periferialDeviceRepository.save(periferialDeviceUpdated);
	             
	            return periferialDeviceUpdated;
	        } else {
	        	periferialDevice = periferialDeviceRepository.save(periferialDevice);
	        	
	            return periferialDevice;
	        }
	}

	@Override
	public void deletePeriferialDeviceById(Long periferialDeviceId) throws RecordNotFoundException {
			
		Optional<PeriferialDevice> periferialDevice = periferialDeviceRepository.findById(periferialDeviceId);
		
		if(periferialDevice.isPresent()) {
			periferialDeviceRepository.deleteById(periferialDeviceId);
		} else {
	        throw new RecordNotFoundException(
	            "No periferialDevice record exist for given id:: " + periferialDeviceId
	        );
	    }
	}
}