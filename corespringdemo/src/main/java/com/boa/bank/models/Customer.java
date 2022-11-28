package com.boa.bank.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private long accountNo;
	private String name;
	private String email;
	private long contactNumber;
	private String address;
	private String password;

}
