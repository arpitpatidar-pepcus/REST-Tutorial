package com.pepcus.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.employee.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
