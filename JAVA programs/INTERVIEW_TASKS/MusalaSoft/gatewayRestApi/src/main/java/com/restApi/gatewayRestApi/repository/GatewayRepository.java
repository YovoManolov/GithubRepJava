package com.restApi.gatewayRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restApi.gatewayRestApi.model.Gateway;

public interface GatewayRepository extends JpaRepository<Gateway, Long> {
	
}
