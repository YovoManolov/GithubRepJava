package com.restApi.gatewayRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restApi.gatewayRestApi.model.PeriferialDevice;

public interface PeriferialDeviceRepository
					extends JpaRepository<PeriferialDevice, Long> {

	@Query("SELECT count(*) "
			+ "FROM PeriferialDevice pd "
			+ "WHERE gateway.id = :gatewayId ")
	public Integer countPerifDForGatewayWithId(long gatewayId);
}
