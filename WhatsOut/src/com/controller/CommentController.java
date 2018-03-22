package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.model.Comment;
import com.model.Event;
import com.model.WhatsOutUser;
import com.service.CommentService;
import com.service.EventService;

/**
 * Author: Yvan GAKUBA
 * The following controller manages the comments made on a event.
 */
@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CommentController() {
        super();
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(request.getParameter("id"));
    	WhatsOutUser user=(WhatsOutUser)request.getSession().getAttribute("wouser");
		if(user==null) {
			response.sendRedirect("/WhatsOut/Login");
		}else {
			List<Comment>comments=new CommentService().findBy(Integer.parseInt(request.getParameter("id")));
			JSONObject[] cmts = new JSONObject[comments.size()];
			int i = 0;
			//convert list to json array
			for (Comment comment : comments) {
				JSONObject jos = new JSONObject();
				jos.put("description", comment.getDescription());
				jos.put("username", comment.getUser().getUserName());
				cmts[i]=jos;
				i++;
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(Arrays.toString(cmts));
			response.getWriter().flush();
		}
    }

    /*The following method receives a request from an ajax call
     * written in Comments.js
     * The author is Yvan GAKUBA*/
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WhatsOutUser user=(WhatsOutUser)request.getSession().getAttribute("wouser");
		if(user==null) {
			response.sendRedirect("/WhatsOut/Login");
		}else {
			CommentService cs=new CommentService();
			Comment comment=new Comment();
			comment.setCommentAt(LocalDateTime.now());
			comment.setDescription(request.getParameter("description"));
			comment.setEvent(new EventService().find(Integer.parseInt(request.getParameter("eventID"))));
			comment.setUser(user);
			cs.addComment(comment);
			JSONObject res = new JSONObject();
			res.put("description", comment.getDescription());
			res.put("commentor", comment.getUser().getUserName());
			res.put("time", comment.getCommentAt().toString());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(res);
			response.getWriter().flush();
		}
	}

}
