package com.equitasit.hello.web_db.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitasit.hello.web_db.entity.Emp;
import com.equitasit.hello.web_db.model.EmpDto;
import com.equitasit.hello.web_db.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<EmpDto> getAll() {
		return empRepository.findAll().stream().map(e -> {
			EmpDto empDto = modelMapper.map(e, EmpDto.class);
			return empDto;
		}).collect(Collectors.toList());
	}

	public EmpDto getEmp(Integer empId) {
		return empRepository.findById(empId).map(e -> {
			EmpDto empDto = modelMapper.map(e, EmpDto.class);
			return empDto;
		}).get();
	}

	public EmpDto save(EmpDto empDto) {
		Emp emp = modelMapper.map(empDto, Emp.class);

		Emp saved = empRepository.save(emp);
		empDto = modelMapper.map(saved, EmpDto.class);

		return empDto;
	}

	public void remove(Integer empId) {

		empRepository.deleteById(empId);

	}

}
