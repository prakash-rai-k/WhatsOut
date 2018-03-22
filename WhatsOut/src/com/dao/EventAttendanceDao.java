package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.dbConnection.QueryExecutor;
import com.model.EventAttendance;

public class EventAttendanceDao {
	/*
	 * Written on March 20, 2018 This function register information about attendance
	 * Uses the model written by Rupendre Maharjan Uses the QueryExecutor Class
	 * written by Yvan GAKUBA
	 * 
	 * @Author Yvan GAKUBA
	 */
	public boolean insert(EventAttendance attendance) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO eventAttendance (signDate, userID, eventID) VALUES(?,?,?)";
		boolean result = qex.insert(query, attendance.getSignDate().toString(), attendance.getUser().getId(),
				attendance.getEvent().getId());
		qex.closeConnection();
		return result;
	}

	/*
	 * Written on March 20, 2018 This function deletes an attendance using the
	 * attendance id Uses the model written by Rupendre Maharjan Uses the
	 * QueryExecutor Class written by Yvan GAKUBA
	 * 
	 * @Author Yvan GAKUBA
	 */
	public boolean delete(EventAttendance ea) {
		QueryExecutor qex = new QueryExecutor();
		String query = "DELETE FROM eventAttendance WHERE eventID=? AND userID=?";
		boolean result = qex.insert(query, ea.getEvent().getId(), ea.getUser().getId());
		qex.closeConnection();
		return result;
	}

	/*
	 * Written on March 20, 2018 This function all events you want to attend and
	 * those you attended Uses the model written by Rupendre Maharjan Uses the
	 * QueryExecutor Class written by Yvan GAKUBA
	 * 
	 * @Author Yvan GAKUBA
	 */
	public List<EventAttendance> get(int userID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM eventAttendance WHERE userID=?";
		List<EventAttendance> eventsAttendance = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query, userID);
			while (rs.next()) {
				String date[] = rs.getString(2).split("-");
				eventsAttendance.add(new EventAttendance(rs.getInt(1),
						LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
						new WhatsOutUserDao().findBy(rs.getInt(3)), new EventDao().get(rs.getInt(4))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return eventsAttendance;
	}

	/*
	 * Written on March 20, 2018 This function retrieves a subscription for a given
	 * subscriber Uses the model written by Rupendre Maharjan Uses the QueryExecutor
	 * Class written by Yvan GAKUBA
	 * 
	 * @Author Yvan GAKUBA
	 */
	public List<EventAttendance> findBy(int eventID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM eventAttendance WHERE eventID=?";
		List<EventAttendance> eventsAttendance = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query, eventID);
			while (rs.next()) {
				String date[] = rs.getString(2).split("-");
				eventsAttendance.add(new EventAttendance(rs.getInt(1),
						LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
						new WhatsOutUserDao().findBy(rs.getInt(3)), new EventDao().get(rs.getInt(4))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return eventsAttendance;
	}

	/*
	 * Written on March 20, 2018 This function return true if a user is attending or
	 * false if not Uses the model written by Rupendre Maharjan Uses the
	 * QueryExecutor Class written by Yvan GAKUBA
	 * 
	 * @Author Yvan GAKUBA
	 */
	public boolean isAttending(int eventID, int userID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM eventAttendance WHERE eventID=? AND userID=?";
		ResultSet rs = qex.getData(query, eventID, userID);
		try {
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException S) {
			return false;
		}
	}
}
