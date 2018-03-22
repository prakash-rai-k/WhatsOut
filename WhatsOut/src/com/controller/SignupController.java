package com.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.WhatsOutUser;
import com.service.AddressService;
import com.service.WhatsOutUserService;

@WebServlet("/Signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressService addressService = new AddressService();
		request.setAttribute("stateList",addressService.getStateList());
		request.getServletContext().getRequestDispatcher("/views/signup/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here");		
			String firstName = request.getParameter("firstname");
			String middleName = request.getParameter("middlename");
			String lastName = request.getParameter("lastname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String userName =  request.getParameter("username");
			String password = request.getParameter("password");
			
			//String password = Base64.encode(request.getParameter("password").getBytes()).toString();
			WhatsOutUser currentUser = new WhatsOutUser(0,userName, password, firstName, lastName, middleName,
					email,phone,"", LocalDate.now(),new AddressService().getAddress(state, city));
			
			System.out.println(currentUser);
			
			//Redirect user to home page if successfull
			WhatsOutUserService woService = new WhatsOutUserService(); 
			if(woService.registerUser(currentUser)) {
				request.getSession().setAttribute("wouser",woService.getUserBy(userName));
				//Cookie cookie= new Cookie("wouser",request.getSession().getId());
				//response.addCookie(cookie);
				request.getRequestDispatcher("./Home").forward(request, response);
			}
			
			//Redirect user to sinup page if fail
			else {
				response.sendRedirect("/Signup");
			}

	}

}
