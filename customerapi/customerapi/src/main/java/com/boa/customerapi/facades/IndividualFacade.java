package com.boa.customerapi.facades;

import java.util.List;

import com.boa.customerapi.models.Individual;

public interface IndividualFacade {
	
	Individual addIndividual(Individual individual);
	List<Individual> getAllIndividuals();
	Individual getIndividualById(long customerId);
	Individual updateIndividual(long customerId, long contactNo, String email, String password);
	boolean deleteIndividual(long customerId);
	List<Individual> getIndividualByFName(String firstName);

}
