package com.restApi.gatewayRestApi.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.Gateway;

public interface GatewayServiceI {
	
	public List<Gateway> getAllGateways();
	public Gateway getGatewayById(
   				@PathVariable(value = "id") Long gatewayId) throws RecordNotFoundException;
	
	public Gateway updateGateway(Gateway newGateway, Long id ) throws RecordNotFoundException;
		
	public Gateway createGateway(Gateway newGateway) throws RecordNotFoundException;

	public void deleteGatewayById(Long gatewayId) throws RecordNotFoundException;
	  
}
