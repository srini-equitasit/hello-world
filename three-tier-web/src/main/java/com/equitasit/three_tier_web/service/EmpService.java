package com.equitasit.three_tier_web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.equitasit.three_tier_app.entity.Emp;
import com.equitasit.three_tier_web.model.EmpDto;

@Service
public class EmpService {

	@Autowired
	private RestTemplate restTemplate;

	public List<EmpDto> getAll() {
		return empRepository.findAll().stream().map(e -> {
			EmpDto empDto = new EmpDto();
			empDto.setDept(e.getDept());
			empDto.setName(e.getName());
			empDto.setId(e.getId());
			return empDto;
		}).collect(Collectors.toList());
	}

	public EmpDto save(EmpDto empDto) {
		Emp emp = new Emp();
		emp.setDept(empDto.getDept());
		emp.setName(empDto.getName());
		Emp saved = empRepository.save(emp);
		empDto.setId(saved.getId());
		return empDto;
	}
}
