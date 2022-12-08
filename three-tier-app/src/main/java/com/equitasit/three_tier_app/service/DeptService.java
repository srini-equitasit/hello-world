package com.equitasit.three_tier_app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitasit.three_tier_app.dto.DeptDTO;
import com.equitasit.three_tier_app.entity.Department;
import com.equitasit.three_tier_app.repository.DepartmentRepository;

@Service
public class DeptService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	public DeptDTO save(DeptDTO deptDTO) {

		Department department = modelMapper.map(deptDTO, Department.class);

		Department savedDepartment = departmentRepository.save(department);

		return modelMapper.map(savedDepartment, DeptDTO.class);
	}

	public void remove(Integer deptNo) {

		departmentRepository.deleteById(deptNo);

	}

	public DeptDTO get(Integer deptno) {

		Optional<Department> deptOptional = departmentRepository.findById(deptno);

		return modelMapper.map(deptOptional.get(), DeptDTO.class);

	}

	public List<DeptDTO> getAll() {

		return departmentRepository.findAll().stream().map(dept -> modelMapper.map(dept, DeptDTO.class))
				.collect(Collectors.toList());

	}
}
