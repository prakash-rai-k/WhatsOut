package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.WhatsOutUser;
import com.service.WhatsOutUserService;

/*
 * Written on March 19, 2018
 * Loads the Login Page 
 * @author Rupendra MAHARJAN 
 */

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/views/login/login.jsp").forward(request, response);
	}

	/*
	 * Written on March 19, 2018 Receives Login Data from user and verifies its
	 * credential Uses WhatsOutUserService created by Rupendra MAHARJAN Gets data
	 * from login page created by Prakash RAI Checks the existence of user based on
	 * Login Database created by Yvan GAKUBA
	 * 
	 * @Author Rupendra MAHARJAN
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 
		 * Checks if username and password is null or not 
		 * */
		if (request.getParameter("login_username") != null || request.getParameter("login_password") != null) {
			String username = request.getParameter("login_username");
			String password = request.getParameter("login_password");
			
			/* 
			 * Creates the new session for the user
			 * */
			request.getSession().getAttribute("wouser");
			String encodePassword = password;// Base64.encode(password.getBytes());
			WhatsOutUserService userService = new WhatsOutUserService();
			WhatsOutUser wouser = userService.getUserbyLogin(username, encodePassword);
			request.getSession().setAttribute("wouser", wouser);
			Cookie cookie = new Cookie("wouser", request.getSession().getId());
			response.addCookie(cookie);

			/*
			 * Checks if the user exists in database or not during login
			 * */
			if (wouser != null) {
				response.sendRedirect("./Home");
			} else {
				/* 
				 * Throws Error message for invalid username or password
				 * */
				request.setAttribute("errMsg", "Invalid Username or Password");
				response.sendRedirect("./Login");
			}
		}
	}
}
