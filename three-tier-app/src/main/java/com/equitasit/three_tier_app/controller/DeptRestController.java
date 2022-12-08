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

import com.equitasit.three_tier_app.dto.DeptDTO;
import com.equitasit.three_tier_app.service.DeptService;

@Controller
@RequestMapping("/dept")
@SuppressWarnings("rawtypes")
public class DeptRestController {

	@Autowired
	private DeptService deptService;

	@DeleteMapping("remove")
	public ResponseEntity removeDeptDetails(@RequestParam("deptId") Integer deptId) {
		deptService.remove(deptId);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("get")
	public ResponseEntity getDeptDetails(@RequestParam("deptId") Integer deptId) {
		DeptDTO deptDTO = deptService.get(deptId);

		return ResponseEntity.ok(deptDTO);
	}

	@PostMapping("save")
	public ResponseEntity saveDept(@RequestBody DeptDTO deptDTO, Model model) {
		DeptDTO saved = deptService.save(deptDTO);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/list")
	public ResponseEntity getDeptList() {

		List deptList = deptService.getAll();

		return ResponseEntity.ok(deptList);
	}

}
