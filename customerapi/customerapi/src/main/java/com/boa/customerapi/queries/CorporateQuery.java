package com.boa.customerapi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class CorporateQuery implements GraphQLQueryResolver{
	@Autowired
	private CorporateService corporateService;
	
	public List<Corporate>findAllCorporates(){
		return this.corporateService.getAllCorporates();
	}
			
			
	public	Corporate findCorporate(Long customerId) {
		return this.corporateService.getCorporateById(customerId);
	}
}
