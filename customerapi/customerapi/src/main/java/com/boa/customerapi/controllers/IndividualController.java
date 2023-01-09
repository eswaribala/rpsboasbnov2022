package com.boa.customerapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;
import io.opentracing.util.GlobalTracer;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
    @Autowired
	private IndividualService individualService;
    @Autowired
    private Tracer tracer;

    @PostMapping({"/v1.0/"})
    @CrossOrigin("*")
    public ResponseEntity<ResponseWrapper> addIndividual(@Valid @RequestBody Individual individual){
    	
    	Individual individualObj=this.individualService.addIndividual(individual);
    	
    	if(individualObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>(individualObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not created due to incorrect values"));
        	
    }
    
    @GetMapping({"/v1.0/"})
    @CrossOrigin("*")
    public List<Individual> findAllIndividuals(){
    	HttpStatus status=null;  

        Tracer tracer = GlobalTracer.get();
        Tracer.SpanBuilder spanBuilder = tracer.buildSpan("CustomerSpan")
                .withTag(Tags.SPAN_KIND.getKey(), Tags.SPAN_KIND_SERVER);
         
        Span span1 = spanBuilder.start();
        Tags.COMPONENT.set(span1, "IndividualAController");
        span1.setTag("testtag", "test");
        span1.finish();
        Span span = tracer.buildSpan("accessing customers").start();
        List<Individual> individuals=this.individualService.getAllIndividuals();
        if (individuals.size()>0) {
            status = HttpStatus.CREATED;
            span.setTag("http.status_code", 201);
        } else {
            span.setTag("http.status_code", 403);
        }
        span.finish();

		return individuals;

    }
    
    
    @GetMapping({"/v1.0/{customerId}"})
    @CrossOrigin("*")
    public ResponseEntity<ResponseWrapper> findIndividualById(@PathVariable("customerId") long customerId){
       Individual individualObj=this.individualService.getIndividualById(customerId);
    	
    	if(individualObj!=null)
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>(individualObj));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found"));
     
    }
    
    @GetMapping({"/v1.0/name/{firstName}"})
    @CrossOrigin("*")
    public ResponseEntity<?> findIndividualByFirstName(@PathVariable("firstName") String firstName){
       List<Individual> individuals=this.individualService.getIndividualByFName(firstName);
    	
    	if(individuals.size()>0)
    		return ResponseEntity.status(HttpStatus.OK).body(individuals);
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found"));
     
    }
    @GetMapping({"/v1.0/rsql/"})
    @CrossOrigin("*")
    public Page<Individual> findIndividualByQuery(
    		@RequestParam String condition,
            @RequestParam(required = false,defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "2") int size,
            @RequestParam(defaultValue = "customerId") String sortBy){
       return this.individualService.conditionalQuery(condition, PageRequest.of(page, size));
    	
    	
     
    }
    @PutMapping({"/v1.0/{customerId}"})
    @CrossOrigin("*")
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
    @CrossOrigin("*")
    public ResponseEntity<ResponseWrapper> deleteIndividualById(@PathVariable("customerId") long customerId){
      
    	
    	if(this.individualService.deleteIndividual(customerId))
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Individual>("Customer Deleted with customerId..."+customerId));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Customer Not found and not deleted..."));
      
    }
}
