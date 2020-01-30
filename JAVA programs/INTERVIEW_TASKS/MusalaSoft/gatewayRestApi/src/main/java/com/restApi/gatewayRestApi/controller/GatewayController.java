package com.restApi.gatewayRestApi.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.Gateway;
import com.restApi.gatewayRestApi.servicesImpl.GatewayServiceImpl;


@RestController
@RequestMapping("/gateways")
public class GatewayController {
	
	@Autowired
	GatewayServiceImpl gatewayServiceImpl;
	
    @GetMapping("/getAll")
    public ResponseEntity<List<Gateway>> getAllGateways() {
    	 List<Gateway> gatewayList = gatewayServiceImpl.getAllGateways();
         return new ResponseEntity<List<Gateway>>(gatewayList, HttpStatus.OK);
    }

    @GetMapping("/getOneById/{id}")
    public ResponseEntity<Gateway> 
    	getGatewayById(@PathVariable(value = "id") Long gatewayId) throws RecordNotFoundException {
    	
        Gateway gateway =  gatewayServiceImpl.getGatewayById(gatewayId);
        return new ResponseEntity<Gateway>(gateway, HttpStatus.OK);
    }

    @PostMapping("/createOrUpdate")
    public ResponseEntity<Gateway> createOrUpdateGateway(Gateway Gateway)
                                                    throws RecordNotFoundException {
        Gateway updated = gatewayServiceImpl.createOrUpdateGateway(Gateway);
        return new ResponseEntity<Gateway>(updated, HttpStatus.OK);
    }
 
    @DeleteMapping("deleteById/{id}")
    public HttpStatus deleteGatewayById(@PathVariable("id") Long gatewayId) 
                                                    throws RecordNotFoundException {
        gatewayServiceImpl.deleteGatewayById(gatewayId);
        return HttpStatus.FORBIDDEN;
    }
}
