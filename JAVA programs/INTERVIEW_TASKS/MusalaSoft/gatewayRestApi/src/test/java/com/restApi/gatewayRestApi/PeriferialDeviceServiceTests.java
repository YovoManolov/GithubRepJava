package com.restApi.gatewayRestApi;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.restApi.gatewayRestApi.repository.PeriferialDeviceRepository;
import com.restApi.gatewayRestApi.servicesImpl.PeriferialDeviceServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PeriferialDeviceServiceTests {
	 
	@Autowired 
	private PeriferialDeviceServiceImpl periferialDeviceServiceImpl;
	
	@MockBean 
	private PeriferialDeviceRepository periferialDeviceRepository;
	
	
	
}
