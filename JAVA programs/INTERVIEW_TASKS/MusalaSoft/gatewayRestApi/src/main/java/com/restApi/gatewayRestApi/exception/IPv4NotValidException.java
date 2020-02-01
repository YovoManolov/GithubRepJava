package com.restApi.gatewayRestApi.exception;

public class IPv4NotValidException extends Exception {
	
    private static final long serialVersionUID = 1L;
    
    public IPv4NotValidException(String message) {
        super(message);
    }
     
    public IPv4NotValidException(String message, Throwable t) {
        super(message, t);
    }
}
