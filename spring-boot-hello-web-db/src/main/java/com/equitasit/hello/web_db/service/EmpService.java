package com.equitasit.hello.web_db.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitasit.hello.web_db.entity.Emp;
import com.equitasit.hello.web_db.model.EmpDto;
import com.equitasit.hello.web_db.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

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
