package com.boa.customerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boa.customerapi.models.Individual;

public interface IndividualRepository extends JpaRepository<Individual, Long>{

	@Query("select i from Individual i where i.name.firstName=:firstName")
	public List<Individual> findByFirstName(@Param("firstName") String firstName);
	
}
