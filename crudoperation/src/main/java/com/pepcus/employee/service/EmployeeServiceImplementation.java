package com.pepcus.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pepcus.employee.exception.ResourceNotFoundException;
import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.repository.AddressRepository;
import com.pepcus.employee.repository.EmployeeRepositoy;

@Service
public class EmployeeServiceImplementation {
	@Autowired
	private EmployeeRepositoy employeeRepositoy;
	@Autowired
	private AddressRepository addressRepository;

	public Employee addemployee(Employee employee) {
		addressRepository.saveAll(employee.getAddress());
		return employeeRepositoy.save(employee);
	}

	public List<Employee> getEmployee() {
		List<Employee> emplist = (List<Employee>) employeeRepositoy.findAll();
		return emplist;
	}

	public String deleteEmployee(int id) {
		try {
			employeeRepositoy.deleteById(id);
		} catch (Exception e) {
			return "employee id not found" + id;
		}
		return "employee delete successfully" + id;
	}

	public ResponseEntity<Employee> updateEmployee(Employee employee, int employeeId) {

		Employee employeeUpdated = employeeRepositoy.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employeeUpdated.setAddress(employee.getAddress());
		employeeUpdated.setEmail(employee.getEmail());
		employeeUpdated.setName(employee.getName());
		employeeUpdated.setPhoneNo(employee.getPhoneNo());
		final Employee updatedEmployee = employeeRepositoy.save(employee);
		return ResponseEntity.ok(updatedEmployee);

	}

}
