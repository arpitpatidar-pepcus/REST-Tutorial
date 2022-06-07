package com.pepcus.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pepcus.employee.model.Employee;

public interface EmployeeService {

  Employee saveEmployee(Employee employee);

  List<Employee> getAllEmployee();

  void deleteEmployeeById(int id);

  Employee updateEmployee(Employee employee);

  List<Employee> findAllSortedByName();

  List<Employee> filterByName(String name);

  Page<Employee> findEmployeeWithPagination(int offset, int pageSize);

}
