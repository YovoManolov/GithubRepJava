package com.restApi.gatewayRestApi.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.gatewayRestApi.model.Gateway;
import com.restApi.gatewayRestApi.repository.GatewayRepository;
import com.restApi.gatewayRestApi.services.GatewayServiceI;

@Service
public class GatewayServiceImpl implements GatewayServiceI {
	
	@Autowired
	GatewayRepository gatewayRepository;
	
	@Override
	public Iterable<Gateway> getAllWithPerifDevices() {
		return gatewayRepository.findAll();//findAllWithPerifDevices();
	}

}
