package com.equitasit.three_tier_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitasit.three_tier_app.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {

}
