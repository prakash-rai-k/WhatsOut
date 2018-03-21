package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dbConnection.QueryExecutor;
import com.model.Address;
import com.model.Event;
import com.model.WhatsOutUser;


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
	/*
	 * Written on March 20, 2018 
	 * This function retrieves an Event using the event title
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public Event get(String title) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM events WHERE title=?";
		Event event = null;
		try {
			ResultSet rs = qex.getData(query,title);
			if (rs.next()) {
				String date[]=rs.getString(5).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				//........................................
				String date1[]=rs.getString(6).split("-");
				String daytime1[]=date1[2].split("T");
				String time1[]=daytime1[1].split(":");
				//........................................
				String date2[]=rs.getString(7).split("-");
				String daytime2[]=date2[2].split("T");
				String time2[]=daytime2[1].split(":");
				event=new Event(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(daytime1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])),
						LocalDateTime.of(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(daytime2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])),
						rs.getInt(8), new AddressDao().findBy(rs.getInt(9)), new EventCategoryDao().findBy(rs.getInt(10)), 
						new WhatsOutUserDao().findBy(rs.getInt(11)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return event;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves an Event using the id
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public Event get(int id) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM events WHERE id=?";
		Event event = null;
		try {
			ResultSet rs = qex.getData(query,id);
			if (rs.next()) {
				String date[]=rs.getString(5).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				//........................................
				String date1[]=rs.getString(6).split("-");
				String daytime1[]=date1[2].split("T");
				String time1[]=daytime1[1].split(":");
				//........................................
				String date2[]=rs.getString(7).split("-");
				String daytime2[]=date2[2].split("T");
				String time2[]=daytime2[1].split(":");
				event=new Event(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(daytime1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])),
						LocalDateTime.of(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(daytime2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])),
						rs.getInt(8), new AddressDao().findBy(rs.getInt(9)), new EventCategoryDao().findBy(rs.getInt(10)), 
						new WhatsOutUserDao().findBy(rs.getInt(11)));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return event;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the events by the provided EventCategory
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	
	public List<Event> findBy(int categoryID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM events WHERE categoryID=?";
		List<Event> events = new ArrayList<>();;
		try {
			ResultSet rs = qex.getData(query,categoryID);
			while (rs.next()) {
				String date[]=rs.getString(5).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				//........................................
				String date1[]=rs.getString(6).split("-");
				String daytime1[]=date1[2].split("T");
				String time1[]=daytime1[1].split(":");
				//........................................
				String date2[]=rs.getString(7).split("-");
				String daytime2[]=date2[2].split("T");
				String time2[]=daytime2[1].split(":");
				events.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(daytime1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])),
						LocalDateTime.of(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(daytime2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])),
						rs.getInt(8), new AddressDao().findBy(rs.getInt(9)), new EventCategoryDao().findBy(rs.getInt(10)), 
						new WhatsOutUserDao().findBy(rs.getInt(11))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return events;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the events by the provided user
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	
	public List<Event> findBy(WhatsOutUser user) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM events WHERE ownerID=?";
		List<Event> events = new ArrayList<>();;
		try {
			ResultSet rs = qex.getData(query,user.getId());
			while (rs.next()) {
				String date[]=rs.getString(5).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				//........................................
				String date1[]=rs.getString(6).split("-");
				String daytime1[]=date1[2].split("T");
				String time1[]=daytime1[1].split(":");
				//........................................
				String date2[]=rs.getString(7).split("-");
				String daytime2[]=date2[2].split("T");
				String time2[]=daytime2[1].split(":");
				events.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(daytime1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])),
						LocalDateTime.of(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(daytime2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])),
						rs.getInt(8), new AddressDao().findBy(rs.getInt(9)), new EventCategoryDao().findBy(rs.getInt(10)), 
						new WhatsOutUserDao().findBy(rs.getInt(11))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return events;
	}
	
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the events by the provided address
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	
	public List<Event> findBy(Address address) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM events WHERE addressId=?";
		List<Event> events = new ArrayList<>();;
		try {
			ResultSet rs = qex.getData(query,address.getId());
			while (rs.next()) {
				String date[]=rs.getString(5).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				//........................................
				String date1[]=rs.getString(6).split("-");
				String daytime1[]=date1[2].split("T");
				String time1[]=daytime1[1].split(":");
				//........................................
				String date2[]=rs.getString(7).split("-");
				String daytime2[]=date2[2].split("T");
				String time2[]=daytime2[1].split(":");
				events.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(daytime1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])),
						LocalDateTime.of(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(daytime2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])),
						rs.getInt(8), new AddressDao().findBy(rs.getInt(9)), new EventCategoryDao().findBy(rs.getInt(10)), 
						new WhatsOutUserDao().findBy(rs.getInt(11))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return events;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the events
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<Event> all() {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM events";
		List<Event> events = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query);
			while (rs.next()) {
				String date[]=rs.getString(5).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				//........................................
				String date1[]=rs.getString(6).split("-");
				String daytime1[]=date1[2].split("T");
				String time1[]=daytime1[1].split(":");
				//........................................
				String date2[]=rs.getString(7).split("-");
				String daytime2[]=date2[2].split("T");
				String time2[]=daytime2[1].split(":");
				events.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						LocalDateTime.of(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(daytime1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1])),
						LocalDateTime.of(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(daytime2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1])),
						rs.getInt(8), new AddressDao().findBy(rs.getInt(9)), new EventCategoryDao().findBy(rs.getInt(10)), 
						new WhatsOutUserDao().findBy(rs.getInt(11))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return events;
	}
	
}
