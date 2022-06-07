package com.pepcus.employee.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name = "Department_Table")
public class Department {
  @Id
  @GeneratedValue
  private int id;

  private String department;

  @JoinColumn(name = "Employee_id")
  @OneToOne(cascade = CascadeType.ALL)
  @JsonBackReference
  private Employee employee;

}