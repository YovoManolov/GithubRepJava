package com.restApi.gatewayRestApi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.gatewayRestApi.exception.ResourceNotFoundException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;
import com.restApi.gatewayRestApi.repository.PeriferialDeviceRepository;

@RestController
@RequestMapping("/periferialDevices")
public class PeriferialDeviceController {
	
		@Autowired
	    private PeriferialDeviceRepository periferialDeviceRepository;

	    @GetMapping("/getAll")
	    public List<PeriferialDevice> getAllPeriferialDevices() {
	        return periferialDeviceRepository.findAll();
	    }

	    @GetMapping("/getOneById/{id}")
	    public ResponseEntity<PeriferialDevice> 
	    	getPeriferialDeviceById(
	    				@PathVariable(value = "id") Long periferialDeviceId
	    			) throws ResourceNotFoundException {
	        PeriferialDevice PeriferialDevice = periferialDeviceRepository.findById(periferialDeviceId)
	        .orElseThrow(() -> new ResourceNotFoundException("PeriferialDevice not found on :: "+ periferialDeviceId));
	        return ResponseEntity.ok().body(PeriferialDevice);
	    }

	    @PostMapping("/create")
	    public PeriferialDevice createPeriferialDevice(@Valid @RequestBody PeriferialDevice periferialDevice) {
	        return periferialDeviceRepository.save(periferialDevice);
	    }

	   @DeleteMapping("/deleteById/{id}")
	   public Map<String, Boolean> deletePeriferialDevice( 
			   					@PathVariable(value = "id") Long PeriferialDeviceId
			   											) throws Exception {
		   
	       PeriferialDevice PeriferialDevice = periferialDeviceRepository.findById(PeriferialDeviceId)
	          .orElseThrow(() -> new ResourceNotFoundException("PeriferialDevice not found on :: "+ PeriferialDeviceId));

	       periferialDeviceRepository.delete(PeriferialDevice);
	       Map<String, Boolean> response = new HashMap<>();
	       response.put("deleted", Boolean.TRUE);
	       return response;
	   }
}
