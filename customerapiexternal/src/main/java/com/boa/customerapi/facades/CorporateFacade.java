package com.boa.customerapi.facades;

import java.util.List;

import com.boa.customerapi.models.CompanyType;
import com.boa.customerapi.models.Corporate;

public interface CorporateFacade {
	
	Corporate addCorporate(Corporate corporate);
	List<Corporate> getAllCorporates();
	Corporate getCorporateById(long customerId);
	Corporate updateCorporate(long customerId, CompanyType companyType);
	boolean deleteCorporate(long customerId);
	

}
