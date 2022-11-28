package com.boa.bank.models;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
public class AnnotatedCustomer {
	
	private long accountNo;
	private FullName name;
	private String email;
	private long contactNo;
	private Address address;
	private String password;
	
	@Autowired
	public AnnotatedCustomer(FullName name, Address address) {		
	
		this.name = name;
		
		this.address = address;

	}
	
	
	
	
	

}
