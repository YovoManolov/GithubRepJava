package com.lab1.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {

	@GetMapping("/")
	public String testMethod() {
		return "hello";
	}
}
