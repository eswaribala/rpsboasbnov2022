package com.boa.bank.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Configuration("customer")
//@Component
public class AnnotatedCustomer {
	
	private long accountNo;
	private FullName name;
	private String email;
	private long contactNo;
	//@Autowired
	//@Qualifier("address1")
	private Address address;
	private String password;
	
	@Autowired
	//not permitted at constructor level
   // @Qualifier("address1")
	public AnnotatedCustomer(FullName name) {	
	
		this.name = name;	

	}
	@Autowired
	@Qualifier("address1")
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	@Bean
	public Transaction createTransaction() {
		return new Transaction();
	}
	
	

}
