package com.equitasit.three_tier_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.equitasit.three_tier_web.model.EmpDto;
import com.equitasit.three_tier_web.service.EmpService;

@Controller
public class ThreeTierWebController {

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
