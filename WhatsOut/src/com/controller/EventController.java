package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.model.Address;
import com.model.Event;
import com.model.EventCategory;
import com.model.WhatsOutUser;
import com.service.AddressService;
import com.service.EventCategoryService;
import com.service.EventService;

/**
*
* @author Prakash 
* Created On: March 21,2018 
* Description: Event controller
*/
@WebServlet("/Event")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * get the list of events that are related to current user
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//redirect to login if there is no usersession
		if(request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		}
		
		else {
			String type = request.getParameter("type");
			EventService eventService = new EventService();
			WhatsOutUser wouser = (WhatsOutUser) request.getSession().getAttribute("wouser");
			List<Event> eventList = eventService.getEventsBy(wouser);
			
			if(type == "attended-events") {
				
			}
			
			JSONObject[] arrEvent = new JSONObject[eventList.size()];
			int i = 0;
			
			//convert list to json array
			for (Event event : eventList) {
				JSONObject res = new JSONObject();
				res.put("id", event.getId());
				res.put("title", event.getTitle());
				res.put("logo", event.getLogo());
				res.put("description", event.getDescription());
				res.put("createdOn", event.getCreatedOn().toString());
				res.put("happeningOn", event.getHappeningOn().toString());
				res.put("endingOn", event.getEndingOn().toString());
				res.put("capacity", event.getCapacity());
				res.put("address", event.getAddress().getCity() + ", " + event.getAddress().getState());
				res.put("eventCreator", event.getEventCreator().getFirstName() + " " + event.getEventCreator().getLastName());
				arrEvent[i] = res;
				i++;
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(Arrays.toString(arrEvent));
			response.getWriter().flush();
		}
	}

	/**
	 * method to add new event 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirect user to login page if there is no session
		if(request.getSession().getAttribute("wouser") == null) {
			System.out.println("here no session");
			response.sendRedirect("/WhatsOut/Login");
		}
		//else process to save event
		else {
			System.out.println("here session");
			EventCategoryService eventCatService = new EventCategoryService();
			AddressService addressService = new AddressService();
			EventService eventService = new EventService();
			WhatsOutUser wouser = (WhatsOutUser) request.getSession().getAttribute("wouser");
			
			//Get values from request
			String title = (String) request.getParameter("title");
			String state = (String) request.getParameter("state");
			String city = (String) request.getParameter("city");
			String time = (String) request.getParameter("time");
			String timeEnd = (String) request.getParameter("timeEnd");
			String description = (String) request.getParameter("description");
			String happeningOn = (String) request.getParameter("happeningOn");
			String endingOn = (String) request.getParameter("endingOn");
			Integer categoryId = Integer.parseInt((String) request.getParameter("category"));
			Integer capacity = Integer.parseInt((String) request.getParameter("capacity"));
			/*System.out.println("Title : " + title + ", State :" + state + ", City : " + city + ", Description:" + description + ", Time : " + time + 
					", happeningOn:" + happeningOn + ", endingOn:" + endingOn + ", categoryId : " + categoryId +", capacity : " + capacity);*/
			
			//Parsing date into localdatetime
			LocalDateTime happeningOnObj = LocalDateTime.of(Integer.parseInt(happeningOn.split("-")[0]), Integer.parseInt(happeningOn.split("-")[1]), Integer.parseInt(happeningOn.split("-")[2]),
					Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));
			
			LocalDateTime endingOnObj = LocalDateTime.of(Integer.parseInt(endingOn.split("-")[0]), Integer.parseInt(endingOn.split("-")[1]), Integer.parseInt(endingOn.split("-")[2]),
					Integer.parseInt(timeEnd.split(":")[0]), Integer.parseInt(timeEnd.split(":")[1]));
			
			EventCategory categoryObj = eventCatService.getEventCategoryBy(categoryId);
			Address addressObj = addressService.getAddress(state, city);
			
			//convert String to LocalDate
			Event event = new Event(0, title, description, "default.png", LocalDateTime.now(), happeningOnObj, endingOnObj,
					capacity, addressObj, categoryObj, wouser);
			System.out.println("OBJ" + event);
			
			if(eventService.addNewEvent(event)) response.getWriter().println("Successfully added your event!!");
			else response.getWriter().println("Failed to add your event!!");
					
		}
		}

}
