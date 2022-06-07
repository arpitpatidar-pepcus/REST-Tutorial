package com.pepcus.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pepcus.employee.model.Employee;

public interface DepartmentRepository extends JpaRepository<Employee, Integer> {

}