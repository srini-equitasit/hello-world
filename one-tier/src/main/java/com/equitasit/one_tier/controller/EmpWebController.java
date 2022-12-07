package com.equitasit.one_tier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.equitasit.one_tier.dto.EmpDto;
import com.equitasit.one_tier.service.EmpService;

@Controller
@RequestMapping("emp")
public class EmpWebController {

	@Autowired
	private EmpService empService;

	@GetMapping("new")
	public String getEmpForm(Model model) {
		model.addAttribute("emp", new EmpDto());
		return "emp_reg";
	}

	@GetMapping("edit")
	public String getEditEmpForm(Model model, @RequestParam("empId") Integer empId) {
		model.addAttribute("emp", empService.getEmp(empId));
		return "emp_reg";
	}

	@GetMapping("remove")
	public String removeEmpDetails(Model model, @RequestParam("empId") Integer empId) {
		empService.remove(empId);
		return "redirect:/emp/list";
	}

	@PostMapping("save")
	public String saveEmp(@ModelAttribute EmpDto emp, Model model) {
		empService.save(emp);
		return "redirect:/emp/list";
	}

	@GetMapping("/list")
	public String getEmpList(@ModelAttribute EmpDto emp, Model model) {

		List empList = empService.getAll();
		model.addAttribute("empList", empList);
		return "emp_list_data";
	}

}
