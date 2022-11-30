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
import com.boa.customerapi.models.CompanyType;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;

@RestController
@RequestMapping("/corporates")
public class CorporateController {
    @Autowired
	private CorporateService corporateService;
	
    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> addCorporate(@RequestBody Corporate Corporate){
    	
    	Corporate corporateObj=this.corporateService.addCorporate(Corporate);
    	
    	if(corporateObj!=null)
    		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<Corporate>(corporateObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not created due to incorrect values"));
        	
    }
    
    @GetMapping({"/v1.0/"})
    public List<Corporate> findAllCorporates(){
    	return this.corporateService.getAllCorporates();
    }
    
    
    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> findCorporateById(@PathVariable("customerId") long customerId){
       Corporate corporateObj=this.corporateService.getCorporateById(customerId);
    	
    	if(corporateObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Corporate>(corporateObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found"));
     
    }
    
    
    
    @PutMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> updateCorporateById(@PathVariable("customerId") long customerId,
    		@RequestParam(name = "companyType") CompanyType companyType 
    		){
       Corporate corporateObj=this.corporateService.updateCorporate(customerId,companyType);
    	
    	if(corporateObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Corporate>(corporateObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer could not be updated due to incorrect values"));
     
    } 
    
    @DeleteMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> deleteCorporateById(@PathVariable("customerId") long customerId){
      
    	
    	if(this.corporateService.deleteCorporate(customerId))
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Corporate>("Customer Deleted with customerId..."+customerId));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found and not deleted..."));
      
    }
}
