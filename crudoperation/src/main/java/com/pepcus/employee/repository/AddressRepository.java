package com.pepcus.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.pepcus.employee.modal.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
