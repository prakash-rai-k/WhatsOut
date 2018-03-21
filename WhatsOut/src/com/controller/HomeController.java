package com.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddressDao;
import com.model.Address;
import com.model.WhatsOutUser;
import com.service.AddressService;
import com.service.WhatsOutUserService;

/**
 *
 * @author Rupendra MAHARJAN
 * Created On: March 20,2018 
 * Description: HomePage
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getServletContext().getRequestDispatcher("/views/home/home.jsp").forward(request,response);
	}

    //Registers new User and Direct to HomePage if user is new
    //Directs the user to Homepage if he is already registered.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
