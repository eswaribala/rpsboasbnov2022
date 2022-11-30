package com.boa.customerapi.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.facades.IndividualFacade;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepository;

@Service
public class IndividualService implements IndividualFacade {
    @Autowired
	private IndividualRepository individualRepository;
    @Autowired
    private EntityManager entityManager;
	@Override
	public Individual addIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return this.individualRepository.save(individual);
	}

	@Override
	public List<Individual> getAllIndividuals() {
		// TODO Auto-generated method stub
		return this.individualRepository.findAll();
	}

	@Override
	public Individual getIndividualById(long customerId) {
		// TODO Auto-generated method stub
		return this.individualRepository.findById(customerId).orElse(null);
	}
	

	@Override
	public List<Individual> getIndividualByFName(String firstName) {
		// TODO Auto-generated method stub
		return this.individualRepository.findByFirstName(firstName);
	}

	@Override
	public Individual updateIndividual(long customerId, long contactNo, String email, String password) {
		// TODO Auto-generated method stub
	
	   Individual individual= this.getIndividualById(customerId);
	   if(individual !=null) {
		   if(contactNo>0)
		   individual.setContactNo(contactNo);
		   if(email!=null && email.length()>0)
		   individual.setEmail(email);
		   if(password!=null && password.length()>0)
		   individual.setPassword(password);
		   return this.individualRepository.save(individual);
	   }
	   else
		   return null;
	}

	@Override
	public boolean deleteIndividual(long customerId) {
		boolean status=false;
		// TODO Auto-generated method stub
		
		  Individual individual= this.getIndividualById(customerId);
		  if(individual !=null)
		  {
			  this.individualRepository.deleteById(customerId);
			  status=true;
		  }
		  return status;
	}

}
