package com.pepcus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.service.EmployeeServiceImplementation;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	@Autowired
	EmployeeServiceImplementation employeeService;

	@PostMapping("/")
	public Employee addemployee(@RequestBody Employee employee) {
		Employee employeeResponse = employeeService.addemployee(employee);
		return employeeResponse;
	}

	@GetMapping("/")
	public List<Employee> getEmployee() {
		List<Employee> employees = employeeService.getEmployee();
		return employees;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		ResponseEntity<Employee> employeeResponse = employeeService.updateEmployee(employee,id);
		return employeeResponse;
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		String success = employeeService.deleteEmployee(id);
		return success;
	}
}
