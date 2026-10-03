package com.apiLearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello/")
	public String sayHello() {
		return "Hello World This is my first API.";
	}
	
	@GetMapping("/hello/{name}")
	public String sayHelloToName(@PathVariable String name) {
		return "Path Variable: Hello my dear " + name;
	}
	
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "Request Parameter: Hello my dear " + name;
	}
}