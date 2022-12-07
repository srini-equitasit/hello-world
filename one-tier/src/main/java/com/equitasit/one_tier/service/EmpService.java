package com.equitasit.one_tier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitasit.one_tier.dto.EmpDto;
import com.equitasit.one_tier.entity.Emp;
import com.equitasit.one_tier.repository.EmpRepository;

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
