package com.equitasit.hello.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

	@GetMapping("/hello-web")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
