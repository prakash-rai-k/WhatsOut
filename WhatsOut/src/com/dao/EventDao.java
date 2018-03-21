package com.dao;

import com.dbConnection.QueryExecutor;
import com.model.Event;

/**
*
* @author Yvan GAKUBA 
* Created On: March 20,2018 
* Description: Event DAO
*/


public class EventDao {
	/*
	 * Written on March 20, 2018 
	 * This function receives an event object and creates an event in the database;
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(Event event) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO events "
				+ "(title,description,logo,createdOn,happeningOn,endingOn,capacity,addressId,categoryId,ownerID)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		boolean result = qex.insert(query,event.getTitle(),event.getDescription(),event.getLogo(),event.getCreatedOn().toString(),
				event.getHappeningOn().toString(),event.getEndingOn().toString(),event.getCapacity(),event.getAddress().getId(),
				event.getEventCategory().getId(),event.getEventCreator().getId());
		qex.closeConnection();
		return result;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function receives an event object and updates the event in the database using the id;
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean update(Event event) {
		QueryExecutor qex = new QueryExecutor();
		String query = "UPDATE events SET title=?, description=?,logo=?,happeningOn=?,endingOn=?,capacity=?,addressId=?,categoryId=?,ownerID=? "
				+ "WHERE id=?";
		boolean result = qex.insert(query,event.getTitle(), event.getDescription(), event.getLogo(), event.getHappeningOn().toString(),
				event.getEndingOn().toString(),event.getCapacity(),event.getAddress().getId(), event.getEventCategory().getId(), event.getEventCreator().getId(),
				event.getId());
		qex.closeConnection();
		return result;
	}
	
	
}
