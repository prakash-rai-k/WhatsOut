package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dao.AddressDao;
import com.model.Address;



public class AddressService{
	
	private AddressDao addressDao;
	public AddressService() {
		super();
		addressDao = new AddressDao();
	}
	/*
	* Written On March 19, 2018
	* Get List of All States
	* Uses DAO Created by Yvan GAKUBA
	* @Author Rupendra MAHARJAN
	*/
	public List<String> getStateList() {
		return addressDao.findAll().stream().map(address -> address.getState()).distinct().collect(Collectors.toList());
	}
	
	/*
	* Written On March 19, 2018
	* Get List of All Available Addresses
	* Uses DAO Created by Yvan GAKUBA
	* @Author Rupendra MAHARJAN
	*/
	public List<Address> getAddressList() {
		return addressDao.findAll();
	}
	
	/*
	* Written On March 19, 2018
	* Get List of Address based on State List
	* Uses DAO Created by Yvan GAKUBA
	* @Author Rupendra MAHARJAN
	*/
	public List<Address> getAddressListByState(String state){
		return addressDao.findBy(state);
	}
	
	/*
	* Written On March 19, 2018
	* Get List of Address by state and city
	* Uses DAO Created by Yvan GAKUBA
	* @Author Rupendra MAHARJAN
	*/
	public Address getAddress(String state, String city) {
		return addressDao.findBy(state, city);
	}
	
	/*
	* Written On March 21, 2018
	* Get List of Cities based on State
	* Uses DAO Created by Yvan GAKUBA
	* @Author Prakash RAI
	*/
	public List<String> getCities(String state) {
		List<Address> addresses = addressDao.findBy(state);
		List<String> cities = new ArrayList<String>();
		
		for(Address address : addresses ){
			cities.add(address.getCity());
		}	
		return cities;
	}
}
