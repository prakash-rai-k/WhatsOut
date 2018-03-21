package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbConnection.QueryExecutor;
import com.model.Address;

/**
 *
 * @author Yvan GAKUBA 
 * Created On: March 20, 2018 
 * Description: Address data
 */
public class AddressDao {
	/*
	 * Written on March 20, 2018 
	 * This function inserts an address in the address table.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(Address address) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO address (state, city) VALUES(?,?)";
		boolean result = qex.insert(query, address.getState(), address.getCity());
		qex.closeConnection();
		return result;
	}

	/*
	 * Written on March 20, 2018 
	 * This function retrieves one address based on the id
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public Address findBy(int id) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM address WHERE id=?";
		Address a = null;
		try {
			ResultSet rs = qex.getData(query,id);
			if (rs.next()) {
				a = new Address(rs.getInt("id"), rs.getString("state"), rs.getString("city"));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return a;
	}
	
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves one address based on the state and city
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public Address findBy(String state, String city) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM address WHERE state=? AND city=?";
		Address a = null;
		try {
			ResultSet rs = qex.getData(query, state, city);
			if (rs.next()) {
				a = new Address(rs.getInt("id"), rs.getString("state"), rs.getString("city"));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return a;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the address in the database
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<Address> findAll() {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM address";
		List<Address> list = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query);
			while (rs.next()) {
				list.add(new Address(rs.getInt("id"), rs.getString("state"), rs.getString("city")));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return list;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all cities based on a given state
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	
	public List<Address> findBy(String state){
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM address WHERE state=?";
		List<Address> cities = new ArrayList<Address>();
		try {
			ResultSet rs = qex.getData(query, state);
			while (rs.next()) {
				cities.add(new Address(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return cities;
	}
}
