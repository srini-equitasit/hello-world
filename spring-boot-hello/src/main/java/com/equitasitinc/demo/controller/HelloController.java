package com.equitasitinc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class HelloController {

	@GetMapping("hello")
	public String hello(@RequestParam(name = "name", required = false) String fullName) {
		return "hello " + fullName;
	}
}
