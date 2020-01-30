package com.restApi.gatewayRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;
import com.restApi.gatewayRestApi.servicesImpl.PeriferialDeviceServiceImpl;

@RestController
@RequestMapping("/periferialDevices")
public class PeriferialDeviceController {
	
	@Autowired
	PeriferialDeviceServiceImpl periferialDeviceServiceImpl;

	@PostMapping("/createOrUpdate")
	public ResponseEntity<PeriferialDevice> createOrUpdateGateway(PeriferialDevice periferialDevice)
			throws RecordNotFoundException {
		PeriferialDevice updated = periferialDeviceServiceImpl.createOrUpdatePeriferialDevice(periferialDevice);
		return new ResponseEntity<PeriferialDevice>(updated, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public HttpStatus deletePeriferialDeviceById(@PathVariable("id") Long periferialDeviceId) throws RecordNotFoundException {
		periferialDeviceServiceImpl.deletePeriferialDeviceById(periferialDeviceId);
		return HttpStatus.FORBIDDEN;
	}
}
