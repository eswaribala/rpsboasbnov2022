package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName {

	@Column(name="FirstName",length = 50, nullable = false)
	private String firstName;
	@Column(name="LastName",length = 50, nullable = false)
	private String lastName;
	@Column(name="MiddleName",length = 50, nullable = true)
	private String middleName;
}
