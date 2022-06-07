package com.pepcus.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pepcus.employee.model.Employee;

@Repository
public interface EmployeeRepository
    extends JpaRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {

  @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
  List<Employee> filterByName(@Param("name") String name);

}
