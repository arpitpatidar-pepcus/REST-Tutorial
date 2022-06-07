package com.pepcus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.employee.model.Employee;
import com.pepcus.employee.repository.AddressRepository;
import com.pepcus.employee.repository.EmployeeRepository;
import com.pepcus.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  private AddressRepository addressRepository;

  @PostMapping("/")
  public Employee saveEmployee(@RequestBody Employee employee) {
    Employee employeeResponse = employeeService.saveEmployee(employee);
    return employeeResponse;
  }

  @GetMapping("/")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployee();
  }

  @GetMapping("/employees/getemployeebbycity")
  public List<Employee> findEmployeeByPagination(@RequestParam(value = "pageno", required = true) int pageNo,
      @RequestParam(value = "size", required = true) int size) {
    Pageable pageable = PageRequest.of(pageNo - 1, size);
    return (List<Employee>) employeeRepository.findAll(pageable);
  }

  @PutMapping("/{id}")
  public Employee updateEmployeeDetails(@RequestBody Employee employee) {
    return employeeService.updateEmployee(employee);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployeeById(@PathVariable("id") int id) {
    employeeService.deleteEmployeeById(id);
  }

  @GetMapping("/findallsortbyname")
  public List<Employee> findAllSortedByName() {
    return employeeService.findAllSortedByName();
  }

  @GetMapping("/filterbyname")
  public List<Employee> filterByName(@RequestParam(value = "name", required = false) String name) {
    return employeeService.filterByName(name);
  }

}
