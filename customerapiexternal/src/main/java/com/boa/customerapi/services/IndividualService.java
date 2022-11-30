package com.boa.customerapi.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boa.customerapi.facades.IndividualFacade;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepository;
import com.github.tennaito.rsql.jpa.JpaCriteriaQueryVisitor;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;

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
	
	
	
	public Page<Individual> conditionalQuery(String condition, Pageable pageable){
        // 1.Create the JPA Visitor
        RSQLVisitor<CriteriaQuery<Individual>, EntityManager> visitor =
        		new JpaCriteriaQueryVisitor<Individual>();
        // 2.Parse a RSQL into a Node
        Node rootNode = new RSQLParser().parse(condition);
        // 3.Create CriteriaQuery
        CriteriaQuery<Individual> criteriaQuery = rootNode.accept(visitor, entityManager);
        List<Individual> total = entityManager.createQuery(criteriaQuery).getResultList();
        List<Individual> resultList = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize()).getResultList();
 
        return new PageImpl<>(resultList,pageable, total.size());

	}

}
