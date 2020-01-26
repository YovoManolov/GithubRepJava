package com.restApi.gatewayRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.gatewayRestApi.model.PeriferialDevice;

public interface PeriferialDeviceRepository
					extends JpaRepository<PeriferialDevice, Long> {

}
