package com.restApi.gatewayRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApi.gatewayRestApi.model.Gateway;

public interface GatewayRepository extends JpaRepository<Gateway, Long> {
	
}
