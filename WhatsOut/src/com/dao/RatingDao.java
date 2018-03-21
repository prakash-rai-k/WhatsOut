package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbConnection.QueryExecutor;
import com.model.Rating;

public class RatingDao {
	/*
	 * Written on March 20, 2018 
	 * This function inserts the rating in the corresponding table
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(Rating rating) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO ratings (value, userID, eventID) VALUES(?,?,?)";
		boolean result = qex.insert(query, rating.getValue(), rating.getUser().getId(), rating.getEvent().getId());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the ratings made on a given event.
	 * It is used by the RatingService.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<Rating> findAll(int eventID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM ratings WHERE eventID=?";
		List<Rating> list = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query,eventID);
			while (rs.next()) {
				list.add(new Rating(rs.getInt(1), rs.getInt(2), new WhatsOutUserDao().findBy(rs.getInt(3)),
						new EventDao().get(rs.getInt(4))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return list;
	}
}
