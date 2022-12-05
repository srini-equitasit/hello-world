package com.equitasit.hello.web_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.equitasit.hello.web_db.model.EmpDto;
import com.equitasit.hello.web_db.service.EmpService;

@Controller
public class HelloWebController {

	@Autowired
	private EmpService empService;

	@GetMapping("/emp_details")
	public String greetingForm(Model model) {
		model.addAttribute("emp", new EmpDto());
		return "emp_reg";
	}

	@PostMapping("/emp_details")
	public String greetingSubmit(@ModelAttribute EmpDto emp, Model model) {
		empService.save(emp);
		List empList = empService.getAll();
		model.addAttribute("empList", empList);
		return "result";
	}

}
