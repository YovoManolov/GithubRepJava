package com.restApi.gatewayRestApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.restApi.gatewayRestApi.exception.RecordNotFoundException;
import com.restApi.gatewayRestApi.exception.ToManyPerifDevicesException;
import com.restApi.gatewayRestApi.model.PeriferialDevice;
import com.restApi.gatewayRestApi.repository.PeriferialDeviceRepository;
import com.restApi.gatewayRestApi.servicesImpl.PeriferialDeviceServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PeriferialDeviceServiceTests {
	 
	@Autowired 
	private PeriferialDeviceServiceImpl periferialDeviceServiceImpl;
	
	@MockBean 
	private PeriferialDeviceRepository periferialDeviceRepository;
	
	@Test
	public void createPeriferialDeviceTest() {

		PeriferialDevice newPeriferialDevice ;
		try {
			newPeriferialDevice = new PeriferialDevice(2L,"Rempel-Hickle",new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse("2018-09-25 20:04:11")
			,false);
			when(periferialDeviceRepository.save(newPeriferialDevice)).thenReturn(newPeriferialDevice);
			
			assertEquals(newPeriferialDevice, periferialDeviceServiceImpl.createPeriferialDevice(newPeriferialDevice));
		} catch (ParseException | ToManyPerifDevicesException e1) {
			e1.printStackTrace();
		}
	}

}
