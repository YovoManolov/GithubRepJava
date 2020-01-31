package com.restApi.gatewayRestApi.exception;

public class ToManyPerifDevicesException extends Exception {
	
    private static final long serialVersionUID = 1L;
    
    public ToManyPerifDevicesException(String message) {
        super(message);
    }
     
    public ToManyPerifDevicesException(String message, Throwable t) {
        super(message, t);
    }
}
