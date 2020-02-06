package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.PolicyService;

@RestController
public class PolicyController {
	public static final String URL = "/policy/{policyNumber}";
	private final PolicyService policyService; 
	
	public PolicyController(final PolicyService policyService) {
		this.policyService = policyService; 
	}
	
	@RequestMapping(URL)
	public String getPolicy(@PathVariable final int policyNumber) {
		return policyService.getPolicy(policyNumber);
	}
}
