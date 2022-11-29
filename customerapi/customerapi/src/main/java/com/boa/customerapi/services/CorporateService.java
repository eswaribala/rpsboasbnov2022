package com.boa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.facades.CorporateFacade;
import com.boa.customerapi.models.CompanyType;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.repositories.CorporateRepository;

@Service
public class CorporateService implements CorporateFacade {
    @Autowired
	private CorporateRepository corporateRepository;
	@Override
	public Corporate addCorporate(Corporate corporate) {
		// TODO Auto-generated method stub
		return this.corporateRepository.save(corporate);
	}

	@Override
	public List<Corporate> getAllCorporates() {
		// TODO Auto-generated method stub
		return this.corporateRepository.findAll();
	}

	@Override
	public Corporate getCorporateById(long customerId) {
		// TODO Auto-generated method stub
		return this.corporateRepository.findById(customerId).orElse(null);
	}

	@Override
	public Corporate updateCorporate(long customerId, CompanyType companyType) {
		// TODO Auto-generated method stub
	
	   Corporate corporate= this.getCorporateById(customerId);
	   if(corporate !=null) {
		   corporate.setCompanyType(companyType);
		   return this.corporateRepository.save(corporate);
	   }
	   else
		   return null;
	}

	@Override
	public boolean deleteCorporate(long customerId) {
		boolean status=true;
		// TODO Auto-generated method stub
		this.corporateRepository.deleteById(customerId);
		  Corporate Corporate= this.getCorporateById(customerId);
		  if(Corporate !=null)
			  status=false;
		  return status;
	}

}
