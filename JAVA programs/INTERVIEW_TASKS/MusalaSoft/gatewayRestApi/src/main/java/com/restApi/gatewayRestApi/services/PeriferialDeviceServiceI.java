package com.restApi.gatewayRestApi.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;

public interface PeriferialDeviceServiceI {
	
	public List<PeriferialDevice> getAllPeriferialDevices();
	
	public PeriferialDevice getPeriferialDeviceById(
   				@PathVariable(value = "id") Long gatewayId) throws RecordNotFoundException;
	
	public PeriferialDevice createOrUpdatePeriferialDevice(PeriferialDevice gateway) 
					throws RecordNotFoundException;
	
	public void deletePeriferialDeviceById(Long gatewayId) throws RecordNotFoundException;
}
