package com.equitasit.one_tier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitasit.one_tier.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
