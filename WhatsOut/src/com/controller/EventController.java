package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.model.Event;
import com.model.WhatsOutUser;
import com.service.EventService;

/**
 * Servlet implementation class EventController
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Event");
		//redirect to login if there is no usersession
		if(request.getSession().getAttribute("wouser") == null) {
			System.out.println("No session");
			response.sendRedirect("/WhatsOut/Login");
		}
		else {
			EventService eventService = new EventService();
			System.out.println("session");
			WhatsOutUser wouser = (WhatsOutUser) request.getSession().getAttribute("wouser");
			List<Event> eventList = eventService.getEventsBy(wouser);
			
			
			JSONObject[] arrEvent = new JSONObject[eventList.size()];
			int i = 0;
			
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
			System.out.println(arrEvent);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(Arrays.toString(arrEvent));
			response.getWriter().flush();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
