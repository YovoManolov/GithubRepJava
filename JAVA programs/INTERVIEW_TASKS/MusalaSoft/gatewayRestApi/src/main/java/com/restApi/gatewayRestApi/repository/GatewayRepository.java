package com.restApi.gatewayRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restApi.gatewayRestApi.model.Gateway;

public interface GatewayRepository extends JpaRepository<Gateway, Long> {
	
//        String FIND_ALL_WITH_PERIF_DEVICES =
//        		"SELECT g.serialNumber, g.name, g.IPv4, "
//        		+ " new List(p.vendor, p.dateCreated, p.status) "
//        		+ " FROM Gateway as g "
//        		+ " JOIN PeriferialDevice as p ";
        
//        String BY_GATEWAY_ID = " WHERE g.id = :idGateway";
        
//        @Query(FIND_ALL_WITH_PERIF_DEVICES)
//        Iterable<Gateway> findAllWithPerifDevices();
        
//        @Query(FIND_ALL_WITH_PERIF_DEVICES + BY_GATEWAY_ID)
//        Gateway findAllWithPerifDevicesByGatewayId(@Param("idGateway") Long idGateway);
        
}
