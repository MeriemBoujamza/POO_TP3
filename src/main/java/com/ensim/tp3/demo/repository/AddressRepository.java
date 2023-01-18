package com.ensim.tp3.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ensim.tp3.demo.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}