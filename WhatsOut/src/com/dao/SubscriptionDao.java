package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.dbConnection.QueryExecutor;
import com.model.Subscription;

public class SubscriptionDao {
	/*
	 * Written on March 20, 2018 
	 * This function creates subscription.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(Subscription s) {
		QueryExecutor qex = new QueryExecutor();
		String query="INSERT INTO subscriptions (subscriptionDate, subscriberid, categoryid) VALUES(?,?,?)";
		boolean result = qex.insert(query,s.getSubscriptionDate().toString(), s.getSubscriber().getId(), s.getCategory().getId());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function Deletes all the subscriptions of a particular user
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean delete(Subscription s) {
		QueryExecutor qex = new QueryExecutor();
		String query="DELETE FROM subscriptions WHERE subscriberid=?";
		boolean result = qex.insert(query,s.getSubscriber().getId());
		qex.closeConnection();
		return result;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function update a subscription in the subscriptions table.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean update(Subscription s) {
		QueryExecutor qex = new QueryExecutor();
		String query="UPDATE subscriptions SET categoryid=? WHERE subscriberid=?";
		boolean result = qex.insert(query,s.getCategory().getId(),s.getSubscriber().getId());
		qex.closeConnection();
		return result;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves subscriptions for a given subscriber
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<Subscription> get(int subscriberID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM subscriptions WHERE subscriberid=?";
		List<Subscription> sb=new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query, subscriberID);
			while (rs.next()) {
				String date[]=rs.getString(2).split("-");
				sb.add(new Subscription(rs.getInt(1),
						LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])), new WhatsOutUserDao().findBy(rs.getInt(3)),
						new EventCategoryDao().findBy(rs.getInt(4))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return sb;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves a subscription for a given subscriber
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public Subscription findBy(int id) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM subscriptions WHERE subscriberid=?";
		Subscription sb=null;
		try {
			ResultSet rs = qex.getData(query, id);
			if (rs.next()) {
				String date[]=rs.getString(2).split("-");
				sb=new Subscription(rs.getInt(1),
						LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])), new WhatsOutUserDao().findBy(rs.getInt(3)),
						new EventCategoryDao().findBy(rs.getInt(4)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return sb;
	}
}
