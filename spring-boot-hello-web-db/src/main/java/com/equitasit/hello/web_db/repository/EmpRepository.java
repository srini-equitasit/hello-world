package com.equitasit.hello.web_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitasit.hello.web_db.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
