package com.in28minutes.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String HelloWorld () {
		return "Hello World";		
	}

}
