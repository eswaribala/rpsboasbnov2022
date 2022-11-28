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
	public AnnotatedCustomer(long accountNo, FullName name, 
			String email, long contactNo, Address address,
			String password) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.password = password;
	}
	
	
	
	
	

}
