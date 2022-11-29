package com.boa.customerapi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AddressId")
	@ApiModelProperty(hidden = true)
	private long addressId;
	@Column(name="DoorNo",length = 5, nullable = false)
	private String doorNo;
	@Column(name="StreetName",length = 100,nullable = false)
	private String streetName;
	@Column(name="City",length = 100,nullable = false)
	private String city;
	@Column(name="State",length = 100,nullable = false)
	private String state;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "CustomerId"), name = "CustomerId")
	private Customer customer;
}
