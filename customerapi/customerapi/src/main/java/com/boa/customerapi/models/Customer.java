package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CustomerId")
	private long customerId;
    @Embedded
    private FullName name;
    @Column(name="ContactNo")
    private long contactNo;
    @Column(name="Email",nullable = false,length = 100)
	private String email;
    @Column(name="Password",nullable = false,length = 10)
	private String password;
	
}
