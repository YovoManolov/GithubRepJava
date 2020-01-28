package com.restApi.gatewayRestApi.services;

import com.restApi.gatewayRestApi.model.Gateway;

public interface GatewayServiceI {

	public Iterable<Gateway> getAllWithPerifDevices();
}
