package com.boa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.dto.ResponseWrapper;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
    @Autowired
	private IndividualService individualService;
	
    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){
    	
    	Individual individualObj=this.individualService.addIndividual(individual);
    	
    	if(individualObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>(individualObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not created due to incorrect values"));
        	
    }
    
    @GetMapping({"/v1.0/"})
    public List<Individual> findAllIndividuals(){
    	return this.individualService.getAllIndividuals();
    }
    
    
    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> findIndividualById(@PathVariable("customerId") long customerId){
       Individual individualObj=this.individualService.getIndividualById(customerId);
    	
    	if(individualObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>(individualObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found"));
     
    }
    
    
    
    @PutMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> updateIndividualById(@PathVariable("customerId") long customerId,
    		@RequestParam(name = "contactNo") long contactNo, 
    		@RequestParam(name = "email") String email, 
			@RequestParam(name="password") String  password){
       Individual individualObj=this.individualService.updateIndividual(customerId,
    		   contactNo, email, password);
    	
    	if(individualObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>(individualObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer could not be updated due to incorrect values"));
     
    } 
    
    @DeleteMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> deleteIndividualById(@PathVariable("customerId") long customerId){
      
    	
    	if(this.individualService.deleteIndividual(customerId))
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>("Customer Deleted with customerId..."+customerId));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found and not deleted..."));
      
    }
}
