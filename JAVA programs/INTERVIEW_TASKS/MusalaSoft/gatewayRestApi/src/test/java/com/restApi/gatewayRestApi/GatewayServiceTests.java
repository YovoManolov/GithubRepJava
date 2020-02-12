package com.restApi.gatewayRestApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.model.Gateway;
import com.restApi.gatewayRestApi.repository.GatewayRepository;
import com.restApi.gatewayRestApi.servicesImpl.GatewayServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class GatewayServiceTests {	
	
	@Autowired 
	private GatewayServiceImpl gatewayServiceImpl;
	
	@MockBean
	private GatewayRepository gatewayRepository;
	
	@Test
	public void findAllGatewaysTest() {
		
		when(gatewayRepository.findAll())
			.thenReturn(
				Stream.of(new Gateway(17,"33395963","nostrum","214.175.247.50"),
					new Gateway(18,"33395963","nostrum","119.86.47.22"),
					new Gateway(19,"33395963","nostrum","187.232.241.124"))
				.collect(Collectors.toList())
			);
		
		assertEquals(3, gatewayServiceImpl.getAllGateways().size());
		
	}
	
	@Test
	public void findGatewayByIdTest() {
		when(gatewayRepository.findAll())
			.thenReturn(
				Stream.of(new Gateway(5,"33395963","nostrum5","214.175.247.50"))
				.collect(Collectors.toList())
			);
		Long gatewayId = 5L;
		try {
			assertEquals(5, (gatewayServiceImpl.
					getGatewayById(gatewayId)).getId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createGatewayTest() {
		
		Gateway newGateway = new Gateway(5,"33395963","nostrum5","214.175.247.50");
		when(gatewayRepository.save(newGateway)).thenReturn(newGateway);
		
		assertEquals(newGateway, gatewayServiceImpl.createGateway(newGateway));
	}
	
}
