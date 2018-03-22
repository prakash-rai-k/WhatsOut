package com.service;

import java.util.List;

import com.dao.CommentDao;
import com.model.Comment;

/**
*
* @author Yvan GAKUBA 
* Created On: March 21, 2018 
* Description: Service to manage the comments made on events.
*/
public class CommentService {
	/*
	 * Written on March 21, 2018 
	 * This function creates an a comment
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public boolean addComment(Comment comment) {
		return new CommentDao().insert(comment);
	}
	/*
	 * Written on March 21, 2018 
	 * This function retrieves the comments made on a event
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public List<Comment> findBy(int eventID) {
		return new CommentDao().findAll(eventID);
	}
}
