package com.pepcus.springbootcrudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.springbootcrudoperation.model.Employee;
import com.pepcus.springbootcrudoperation.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepository;

	@Override
	public Employee insertEmployee(Employee employee) {

		return employeerepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeelist = (List<Employee>) employeerepository.findAll();
		return employeelist;
	}

	@Override
	public String getDeleteEmployeeById(int id) {
		try {
			employeerepository.deleteById(id);
		} catch (Exception e) {
			return "Employee id not found==>" + id;
		}
		return "Employee delete Successfully==>" + id;
	}

}