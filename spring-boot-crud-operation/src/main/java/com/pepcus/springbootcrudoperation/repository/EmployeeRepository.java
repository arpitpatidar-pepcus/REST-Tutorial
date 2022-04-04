package com.pepcus.springbootcrudoperation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.springbootcrudoperation.model.Employee;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
