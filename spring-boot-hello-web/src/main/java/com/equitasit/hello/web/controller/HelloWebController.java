package com.equitasit.hello.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.equitasit.hello.web.model.EmpDto;

@Controller
public class HelloWebController {

	private List<EmpDto> empList = new ArrayList<>();

	@GetMapping("/emp_details")
	public String greetingForm(Model model) {
		model.addAttribute("emp", new EmpDto());
		return "emp_reg";
	}

	@PostMapping("/emp_details")
	public String greetingSubmit(@ModelAttribute EmpDto emp, Model model) {
		empList.add(emp);
		model.addAttribute("empList", empList);
		return "result";
	}

}
