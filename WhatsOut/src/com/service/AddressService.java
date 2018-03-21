package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dao.AddressDao;
import com.model.Address;

/**
*
* @author Rupendra MAHARJAN 
* Created On: March 20,2018 
* Description: Service related to Address Information
*/
public class AddressService{
	
	private AddressDao addressDao;
	public AddressService() {
		super();
		addressDao = new AddressDao();
	}

	//Get all List of States
	public List<String> getStateList() {
		return addressDao.findAll().stream().map(address -> address.getState()).distinct().collect(Collectors.toList());
	}
	
	//Get all list of Addresses
	public List<Address> getAddressList() {
		return addressDao.findAll();
	}
	
	public List<Address> getAddressListByState(String state){
		return addressDao.findBy(state);
	}
	
	public Address getAddress(String state, String city) {
		return addressDao.findBy(state, city);
	}
}
