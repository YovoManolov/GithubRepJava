package com.restApi.gatewayRestApi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.restApi.gatewayRestApi.model.Gateway;
import com.restApi.gatewayRestApi.repository.GatewayRepository;

@RestController
@RequestMapping("/gateways")
public class GatewayController {
	
	@Autowired
    private GatewayRepository gatewayRepository;

    @GetMapping("/getAll")
    public List<Gateway> getAllGateways() {
        return (List<Gateway>) gatewayRepository.findAll();//findAllWithPerifDevices();
    }

    @GetMapping("/getOneById/{id}")
    public ResponseEntity<Gateway> 
    	getGatewayById(
    				@PathVariable(value = "id") Long gatewayId
    			) throws ResourceNotFoundException {
        Optional<Gateway> gateway =  gatewayRepository.findById(gatewayId);//findAllWithPerifDevicesByGatewayId(gatewayId);
        if(gateway.get() == null) {
        	throw new ResourceNotFoundException("Gateway not found on :: "+ gatewayId);
        }
        return ResponseEntity.ok().body(gateway.get());
    }

    @PostMapping("/create")
    public Gateway createGateway(@Valid @RequestBody Gateway gateway) {
        return gatewayRepository.save(gateway);
    }

   @DeleteMapping("/deleteById/{id}")
   public Map<String, Boolean> deleteGateway( 
		   					@PathVariable(value = "id") Long gatewayId
		   											) throws Exception {
	   
       Gateway Gateway = gatewayRepository.findById(gatewayId)
          .orElseThrow(() -> new ResourceNotFoundException("Gateway not found on :: "+ gatewayId));

       gatewayRepository.delete(Gateway);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}
