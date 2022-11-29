package com.boa.customerapi.facades;

import java.util.List;

import com.boa.customerapi.models.Address;

public interface AddressFacade {
	
	Address addAddress(Address address);
	List<Address> getAllAddresss();
	Address getAddressById(long addressId);
	Address updateAddress(Address address);
	boolean deleteAddress(long addressId);
	

}
