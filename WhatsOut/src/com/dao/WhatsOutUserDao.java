package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.dbConnection.QueryExecutor;
import com.model.WhatsOutUser;

/**
 *
 * @author Yvan GAKUBA 
 * Created On: March 19,2018 
 * Description: WhatOutUser data access.
 */

public class WhatsOutUserDao {
	/*
	 * Written on March 20, 2018 
	 * This function inserts an WhatsoutUser in the whatsoutusers table.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(WhatsOutUser whatsOutUser) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO whatsoutusers "
				+ "(userName,password,firstName,lastName,middleName,email,phone,profilePicture,joinDate,addressid)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		boolean result = qex.insert(query, whatsOutUser.getUserName(), whatsOutUser.getPassword(), whatsOutUser.getFirstName(),
				whatsOutUser.getLastName(), whatsOutUser.getMiddleName(), whatsOutUser.getEmail(), whatsOutUser.getPhone(), whatsOutUser.getProfilePicture(),
				whatsOutUser.getJoinDate().toString(), whatsOutUser.getAddress().getId());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function updates WhatsoutUser in the whatsoutusers table.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean update(WhatsOutUser whatsOutUser) {
		QueryExecutor qex = new QueryExecutor();
		String query = "UPDATE whatsoutusers SET password=?,firstName=?,lastName=?,middleName=?,email=?,phone=?,"
				+ "profilePicture=?,addressid=? WHERE username=?";
		boolean result = qex.update(query, whatsOutUser.getPassword(), whatsOutUser.getFirstName(),
				whatsOutUser.getLastName(), whatsOutUser.getMiddleName(), whatsOutUser.getEmail(), whatsOutUser.getPhone(), whatsOutUser.getProfilePicture(),
				whatsOutUser.getAddress().getId(),whatsOutUser.getUserName());
		qex.closeConnection();
		return result;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves a WhatsOutUser based on the username and password
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public WhatsOutUser findBy(String username, String password) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM whatsoutusers WHERE username=? AND password=?";
		WhatsOutUser user = null;
		try {
			ResultSet rs = qex.getData(query, username, password);
			if (rs.next()) {
				String date[]=rs.getString(10).split("-");
				user = new WhatsOutUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new AddressDao().findBy(rs.getInt(11)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return user;
	}
	
	public WhatsOutUser findBy(int id) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM whatsoutusers WHERE id=?";
		WhatsOutUser user = null;
		try {
			ResultSet rs = qex.getData(query,id);
			if (rs.next()) {
				String date[]=rs.getString(10).split("-");
				user = new WhatsOutUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new AddressDao().findBy(rs.getInt(11)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return user;
	}
	
}
