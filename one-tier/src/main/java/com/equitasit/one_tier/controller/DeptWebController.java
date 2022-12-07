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

import com.equitasit.one_tier.dto.DeptDTO;
import com.equitasit.one_tier.dto.EmpDto;
import com.equitasit.one_tier.service.DeptService;

@Controller
@RequestMapping("/dept")
@SuppressWarnings("rawtypes")
public class DeptWebController {

	@Autowired
	private DeptService deptService;

	@GetMapping("new")
	public String getDeptForm(Model model) {
		model.addAttribute("dept", new DeptDTO());
		return "dept_reg";
	}

	@GetMapping("edit")
	public String getEditDeptForm(Model model, @RequestParam("deptId") Integer deptId) {
		model.addAttribute("dept", deptService.get(deptId));
		return "dept_reg";
	}

	@GetMapping("remove")
	public String removeDeptDetails(Model model, @RequestParam("deptId") Integer deptId) {
		deptService.remove(deptId);
		return "redirect:/dept/list";
	}

	@PostMapping("save")
	public String saveDept(@ModelAttribute DeptDTO deptDTO, Model model) {
		deptService.save(deptDTO);
		return "redirect:/dept/list";
	}

	@GetMapping("/list")
	public String getDeptList(@ModelAttribute EmpDto emp, Model model) {

		List deptList = deptService.getAll();
		model.addAttribute("deptList", deptList);
		return "dept_list_data";
	}

}
