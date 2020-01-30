package com.restApi.gatewayRestApi.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.Gateway;
import com.restApi.gatewayRestApi.repository.GatewayRepository;
import com.restApi.gatewayRestApi.services.GatewayServiceI;

@Service
public class GatewayServiceImpl implements GatewayServiceI {
	
	@Autowired
	GatewayRepository gatewayRepository;

	@Override
	public List<Gateway> getAllGateways() {
		
		List<Gateway> gatewayList = gatewayRepository.findAll();
		
        if(gatewayList.size() > 0) {
            return gatewayList;
        } else {
            return new ArrayList<Gateway>();
        }
	}

	@Override
	public Gateway getGatewayById(Long gatewayId) throws RecordNotFoundException {
		
	    Optional<Gateway> gateway =  gatewayRepository.findById(gatewayId);
	    
	    if(gateway.isPresent()) {
            return gateway.get();
        } else {
            throw new RecordNotFoundException("No gateway record exist for given id");
        }
	}

	@Override
	public Gateway createOrUpdateGateway(Gateway gateway) throws RecordNotFoundException {
		 
	       Optional<Gateway> gatewayOptional = gatewayRepository.findById(gateway.getId());
	         
	        if(gatewayOptional.isPresent()) 
	        {
	            Gateway gatewayUpdated = gatewayOptional.get();
	            gatewayUpdated.setId(gateway.getId()); 
	            gatewayUpdated.setIPv4(gateway.getIPv4());
	            gatewayUpdated.setName(gateway.getName());
	            gatewayUpdated.setPeriferialDevices(gateway.getPeriferialDevices());
	            gatewayUpdated.setSerialNumber(gateway.getSerialNumber());
	 
	            gatewayUpdated = gatewayRepository.save(gatewayUpdated);
	             
	            return gatewayUpdated;
	        } else {
	        	gateway = gatewayRepository.save(gateway);
	             
	            return gateway;
	        }      
		 
	}

	@Override
	public void deleteGatewayById(Long gatewayId) throws RecordNotFoundException {
			
		Optional<Gateway> gateway = gatewayRepository.findById(gatewayId);
		
		if(gateway.isPresent()) {
			gatewayRepository.deleteById(gatewayId);
		} else {
	        throw new RecordNotFoundException(
	            "No gateway record exist for given id:: " + gatewayId
	        );
	    }
	}

}
