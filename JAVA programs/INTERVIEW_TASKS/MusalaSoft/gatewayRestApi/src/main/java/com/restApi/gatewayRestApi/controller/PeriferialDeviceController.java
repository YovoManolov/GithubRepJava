package com.restApi.gatewayRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.exception.ToManyPerifDevicesException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;
import com.restApi.gatewayRestApi.servicesImpl.PeriferialDeviceServiceImpl;

@RestController
@RequestMapping("/periferialDevices")
public class PeriferialDeviceController {
	
	@Autowired
	PeriferialDeviceServiceImpl periferialDeviceServiceImpl;

	@PutMapping("/create")
	public ResponseEntity<PeriferialDevice> createPeriferialDevice(
			@RequestBody PeriferialDevice newPeriferialDevice)
			throws ToManyPerifDevicesException {
		PeriferialDevice created = periferialDeviceServiceImpl.createPeriferialDevice(newPeriferialDevice);
		return new ResponseEntity<PeriferialDevice>(created, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PeriferialDevice> updatePeriferialDevice(
			@RequestBody PeriferialDevice newPeriferialDevice, @PathVariable Long id )
			throws RecordNotFoundException {
		PeriferialDevice updated = periferialDeviceServiceImpl.updatePeriferialDevice(newPeriferialDevice,id);
		return new ResponseEntity<PeriferialDevice>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Object> deletePeriferialDeviceById(@PathVariable("id") Long periferialDeviceId) throws RecordNotFoundException {
		return  periferialDeviceServiceImpl.deletePeriferialDeviceById(periferialDeviceId);
	}
}
