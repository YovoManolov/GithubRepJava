package com.restApi.gatewayRestApi.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;
import com.restApi.gatewayRestApi.repository.PeriferialDeviceRepository;
import com.restApi.gatewayRestApi.services.PeriferialDeviceServiceI;



@Service
public class PeriferialDeviceServiceImpl implements PeriferialDeviceServiceI {
	
	@Autowired
	PeriferialDeviceRepository periferialDeviceRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

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
	public PeriferialDevice createPeriferialDevice( PeriferialDevice newPeriferialDevice) 
							throws RecordNotFoundException {
	         return periferialDeviceRepository.save(newPeriferialDevice);
	}

	@Override
	public PeriferialDevice updatePeriferialDevice(PeriferialDevice newPeriferialDevice, Long id )
						throws RecordNotFoundException {
	
		  Optional<Object> updatedPeriferialDevice = 
				  periferialDeviceRepository.findById(id).map(periferialDevice -> {
			  periferialDevice.setVendor(newPeriferialDevice.getVendor());
			  periferialDevice.setDateCreated(newPeriferialDevice.getDateCreated()); 
			  periferialDevice.setGateway(newPeriferialDevice.getGateway()); 
			  periferialDevice.setStatus(newPeriferialDevice.getStatus()); 
			  return  periferialDeviceRepository.save(periferialDevice);
	       });
		  
		  return (PeriferialDevice) updatedPeriferialDevice.get();
	}
	
	@Override
	public ResponseEntity<Object> deletePeriferialDeviceById(Long periferialDeviceId)
													throws RecordNotFoundException {
			
		Optional<PeriferialDevice> periferialDevice = periferialDeviceRepository
				.findById(periferialDeviceId);
		
		if(periferialDevice.isPresent()) {
			periferialDeviceRepository.deleteById(periferialDeviceId);
		} else {
	        throw new RecordNotFoundException(
	            "No periferialDevice record exist for given id:: " + periferialDeviceId
	        );
	    }
		
		return ResponseEntity.ok().build();
		
	}
}