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

/**
 *
 * @author Rupendra MAHARJAN Created Date: March 19, 2018 Description: Loads the
 *         first page of the screen
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Checks if username and password is null or not
		if (request.getParameter("login_username") != null || request.getParameter("login_password") != null) {
			String username = request.getParameter("login_username");
			String password = request.getParameter("login_password");
			request.getSession().getAttribute("wouser");
			String encodePassword = password;//Base64.encode(password.getBytes());
			WhatsOutUserService userService = new WhatsOutUserService();
			WhatsOutUser wouser = userService.getUserbyLogin(username, encodePassword);
			request.getSession().setAttribute("wouser",wouser);
			Cookie cookie= new Cookie("wouser",request.getSession().getId());
			response.addCookie(cookie);
			
			//Checks if the user exists in database or not during login
			if(wouser!=null) {				
				response.sendRedirect("./Home");
//				request.getServletContext().getRequestDispatcher("/Home").forward(request, response);
			}else {
				//Throws Error message for invalid username or password
				request.setAttribute("errMsg", "Invalid Username or Password");
				this.doGet(request, response);
			}
		}
	}
}
