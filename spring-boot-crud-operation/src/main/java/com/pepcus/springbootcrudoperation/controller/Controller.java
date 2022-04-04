package com.pepcus.springbootcrudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.springbootcrudoperation.model.Employee;
import com.pepcus.springbootcrudoperation.service.EmployeeService;



@RestController
@RequestMapping(value = "/Empl")
public class Controller {
	@Autowired
	EmployeeService employeeservice;

	@PostMapping("/insert")
	public Employee insertEmployee(@RequestBody Employee employee) {
		Employee emp = employeeservice.insertEmployee(employee);
		return emp;
	}

	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee> employees = employeeservice.getAllEmployee();
		return employees;
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee Emp = employeeservice.insertEmployee(employee);
		return Emp;
	}

	@DeleteMapping("/delete/{id}")
	public String getDeleteEmployeeById(@PathVariable("id") int id) {
		System.out.println("book id-->" + id);
		String successfull = employeeservice.getDeleteEmployeeById(id);
		return successfull;
	}

}
