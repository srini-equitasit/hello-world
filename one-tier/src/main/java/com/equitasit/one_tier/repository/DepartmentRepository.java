package com.equitasit.one_tier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitasit.one_tier.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {

}
