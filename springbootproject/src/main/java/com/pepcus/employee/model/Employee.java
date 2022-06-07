package com.pepcus.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Employee")
@Data
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int employeeid;
  private String name;
  private String email;
  private String phoneno;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "employeeid")
  private List<Address> address;

  @JoinColumn
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
  private Department department;
}
