package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName {

	@Column(name="FirstName",length = 50, nullable = false)
	@NotBlank(message = "First Name is mandatory")
	@Size(min=5, message="First Name should have atleast 5 characters")
	private String firstName;
	@Column(name="LastName",length = 50, nullable = false)
	@NotBlank(message = "Last Name is mandatory")
	@Size(min=5, message="Last Name should have atleast 5 characters")
	private String lastName;
	@Column(name="MiddleName",length = 50, nullable = true)
	private String middleName;
}
