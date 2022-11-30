package com.boa.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapi.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
