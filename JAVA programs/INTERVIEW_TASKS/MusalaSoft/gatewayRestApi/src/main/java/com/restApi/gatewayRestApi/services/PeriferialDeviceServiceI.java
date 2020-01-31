package com.restApi.gatewayRestApi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;

public interface PeriferialDeviceServiceI {
	
	public List<PeriferialDevice> getAllPeriferialDevices();

	public PeriferialDevice getPeriferialDeviceById(@PathVariable(value = "id") Long gatewayId)
			throws RecordNotFoundException;

	public PeriferialDevice createPeriferialDevice(PeriferialDevice newPeriferialDevice) 
			throws RecordNotFoundException;

	public PeriferialDevice updatePeriferialDevice(PeriferialDevice newPeriferialDevice, Long id)
			throws RecordNotFoundException;

	public ResponseEntity<Object> deletePeriferialDeviceById(Long periferialDeviceId) 
			throws RecordNotFoundException;
}
