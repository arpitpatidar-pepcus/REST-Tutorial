package com.pepcus.employee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pepcus.employee.model.Employee;
import com.pepcus.employee.repository.AddressRepository;
import com.pepcus.employee.repository.DepartmentRepository;
import com.pepcus.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  AddressRepository addressrepository;
  @Autowired
  DepartmentRepository departmentRepository;
  Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

  @Override
  public Employee saveEmployee(Employee employee) {
    employeeRepository.save(employee);
    addressrepository.saveAll(employee.getAddress());
    return employee;
  }

  @Override
  public List<Employee> getAllEmployee() {
    List<Employee> employeelist = (List<Employee>) employeeRepository.findAll();
    return employeelist;
  }

  @Override
  public void deleteEmployeeById(int id) {
    employeeRepository.deleteById(id);
    LOGGER.info("Employee delete Successfully==>" + id);
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> filterByName(String name) {
    return employeeRepository.filterByName(name);
  }

  @Override
  public Page<Employee> findEmployeeWithPagination(int offset, int pageSize) {
    return departmentRepository.findAll(PageRequest.of(offset, pageSize));
  }

  @Override
  public List<Employee> findAllSortedByName() {
    return employeeRepository.findAll(Sort.by("name").ascending());
  }
}
