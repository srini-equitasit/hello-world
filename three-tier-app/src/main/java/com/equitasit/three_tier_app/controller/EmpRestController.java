package com.equitasit.three_tier_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.equitasit.three_tier_app.dto.EmpDto;
import com.equitasit.three_tier_app.service.EmpService;

@Controller
@RequestMapping("emp")
@SuppressWarnings("rawtypes")
public class EmpRestController {

	@Autowired
	private EmpService empService;

	@DeleteMapping("remove")
	public ResponseEntity removeEmpDetails(@RequestParam("empId") Integer empId) {
		empService.remove(empId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("get")
	public ResponseEntity getEmpDetails(@RequestParam("empId") Integer empId) {
		EmpDto empDto = empService.getEmp(empId);
		return ResponseEntity.ok(empDto);
	}

	@PostMapping("save")
	public ResponseEntity saveEmp(@RequestBody EmpDto emp, Model model) {
		EmpDto saved = empService.save(emp);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/list")
	public ResponseEntity getEmpList() {

		List empList = empService.getAll();

		return ResponseEntity.ok(empList);
	}

}
