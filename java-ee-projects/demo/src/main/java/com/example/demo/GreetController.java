package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class GreetController {

	@RequestMapping(method=RequestMethod.GET)
	public String greet() {
		return "Hello World";
	}
}
