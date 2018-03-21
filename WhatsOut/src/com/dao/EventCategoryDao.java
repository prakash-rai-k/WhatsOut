package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dbConnection.QueryExecutor;
import com.model.EventCategory;

/**
*
* @author Yvan GAKUBA 
* Created On: March 20,2018 
* Description: EventCategory data access.
*/
public class EventCategoryDao {
	/*
	 * Written on March 20, 2018 
	 * This function inserts an Event categories in the eventcategories table.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(EventCategory category) {
		QueryExecutor qex = new QueryExecutor();
		String query="INSERT INTO eventcategories (name, description) VALUES(?,?)";
		boolean result = qex.insert(query,category.getName(),category.getDescription());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function updates an Event categories in the eventcategories table.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean update(EventCategory category) {
		QueryExecutor qex = new QueryExecutor();
		String query="UPDATE eventcategories SET name=?,description=? WHERE id=?";
		boolean result = qex.insert(query,category.getName(),category.getDescription(), category.getId());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves an event categories by ID
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public EventCategory findBy(int id) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM eventcategories WHERE id=?";
		EventCategory ec = null;
		try {
			ResultSet rs = qex.getData(query, id);
			if (rs.next()) {
				ec=new EventCategory(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return ec;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves an event categories by name
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public EventCategory findBy(String name) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM eventcategories WHERE name=?";
		EventCategory ec = null;
		try {
			ResultSet rs = qex.getData(query, name);
			if (rs.next()) {
				ec=new EventCategory(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return ec;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the event categories
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<EventCategory> findAll() {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM eventcategories";
		List<EventCategory> list = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query);
			while (rs.next()) {
				list.add(new EventCategory(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return list;
	}
	
}
