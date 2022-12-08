package com.equitasit.three_tier_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitasit.three_tier_app.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
