package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.EventCategory;
import com.model.WhatsOutUser;
import com.service.AddressService;
import com.service.EventService;
import com.service.SubscriptionService;

/**
*
* @author Prakash 
* Created On: March 20,2018 
* Description: Event Service
*/

@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

    /* 
     * Get method for home page
     * passes eventList in request
     * passes user preferences
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		//redirect to login if there is no usersession
		if(request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		}
		else {
			WhatsOutUser wouser = (WhatsOutUser) request.getSession().getAttribute("wouser");
			EventService eventService = new EventService();
			SubscriptionService subscriptionService = new SubscriptionService();
			AddressService addressService = new AddressService();
			
			//List all subscribed categories
			List<EventCategory> subscribedCategories = subscriptionService.getSubscribedCategories(wouser.getId());
			List<EventCategory> categories = subscriptionService.getEventCategories();
			List<String> states = addressService.getStateList();
			List<String> cities = addressService.getCities(wouser.getAddress().getState());
			
			//Adding categories subscribed by logged in user
			//Adding events list related to user
	    	request.setAttribute("categoryList", subscribedCategories);
	    	request.setAttribute("events", eventService.getAll());
	    	request.setAttribute("states", states);
	    	request.setAttribute("cities", cities);
	    	request.setAttribute("userState", wouser.getAddress().getState());
	    	request.setAttribute("userCity", wouser.getAddress().getCity());
	    	request.setAttribute("categories", categories);
	    	
	    	request.getServletContext().getRequestDispatcher("/views/home/home.jsp").forward(request,response);
		}
		
	}

}
