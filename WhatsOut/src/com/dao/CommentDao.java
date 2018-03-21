package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dbConnection.QueryExecutor;
import com.model.Comment;

public class CommentDao {
	/*
	 * Written on March 20, 2018 
	 * This function inserts a comment in the comments table
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(Comment comment) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO comments (description, commentAt, userID, eventID) VALUES(?,?,?,?)";
		boolean result = qex.insert(query, comment.getDescription(), comment.getCommentAt().toString(),
				comment.getUser().getId(), comment.getEvent().getId());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function removes a comment using the comment id
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean delete(int id) {
		QueryExecutor qex = new QueryExecutor();
		String query = "DELETE FROM comments WHERE id=?";
		boolean result = qex.insert(query, id);
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves all the comments made on a given event
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<Comment> findAll(int eventID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM comments WHERE eventID=?";
		List<Comment> list = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query,eventID);
			while (rs.next()) {
				String date[]=rs.getString(3).split("-");
				String daytime[]=date[2].split("T");
				String time[]=daytime[1].split(":");
				list.add(new Comment(rs.getInt(1), rs.getString(2), 
						LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(daytime[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1])),
						new WhatsOutUserDao().findBy(rs.getInt(4)),
						new EventDao().get(rs.getInt(5))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return list;
	}
}
