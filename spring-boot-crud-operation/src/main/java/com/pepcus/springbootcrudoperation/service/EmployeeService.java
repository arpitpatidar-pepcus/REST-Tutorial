package com.pepcus.springbootcrudoperation.service;

import java.util.List;

import com.pepcus.springbootcrudoperation.model.Employee;



public interface EmployeeService {

	Employee insertEmployee(Employee employee);

	List<Employee> getAllEmployee();

	String getDeleteEmployeeById(int id);
    
}
