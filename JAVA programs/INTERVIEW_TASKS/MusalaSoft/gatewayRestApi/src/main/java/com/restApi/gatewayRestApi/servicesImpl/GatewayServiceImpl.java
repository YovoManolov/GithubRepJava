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
	
	
	GatewayRepository gatewayRepository;
	
	@Autowired
	public GatewayServiceImpl(GatewayRepository gatewayRepository) {
		super();
		this.gatewayRepository = gatewayRepository;
	}

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
	public Gateway createGateway( Gateway newGateway) {
	     return gatewayRepository.save(newGateway);
	}

	@Override
	public Gateway updateGateway(Gateway newGateway, Long id ) throws RecordNotFoundException {
	
		Optional<Object> updatedGateway = gatewayRepository.findById(id)
														.map(gatewayUpdated -> {
			gatewayUpdated.setIPv4(newGateway.getIPv4());
			gatewayUpdated.setName(newGateway.getName());
			gatewayUpdated.setPeriferialDevices(newGateway.getPeriferialDevices());
			gatewayUpdated.setSerialNumber(newGateway.getSerialNumber());

			return gatewayRepository.save(gatewayUpdated);
		});

		return (Gateway) updatedGateway.get();
	}

}
