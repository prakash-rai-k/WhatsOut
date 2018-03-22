package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.model.Event;
import com.model.EventCategory;
import com.model.Subscription;
import com.model.WhatsOutUser;
import com.service.CategoryService;
import com.service.EventCategoryService;
import com.service.SubscriptionService;

/*
 * Written on March 19, 2018
 * It creates JSON object of Event Categories
 * @Author Rupendra MAHARJAN
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {
		super();
	}

	/*
	 * Returns the JSON object for event categories
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to login if there is no usersession
		if (request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		} else {
			CategoryService categoryService = new CategoryService();
			List<EventCategory> categoryList = categoryService.getCategoryList();
			JSONObject[] arrCategory = new JSONObject[categoryList.size()];
			for (int i = 0; i < categoryList.size(); ++i) {
				JSONObject res = new JSONObject();
				res.put("category", categoryList.get(i).getName());
				arrCategory[i] = res;
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(Arrays.toString(arrCategory));
			response.getWriter().flush();
		}
	}

	/*
	 * Inserts new category inserted by the user into the database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("category");
		//redirect to login if there is no usersession
				if(request.getSession().getAttribute("wouser") == null) {
					response.sendRedirect("/WhatsOut/Login");
				}
				else {
					System.out.println("session");
				String newCategory = request.getParameter("category");
				String newDescription = request.getParameter("description");
				EventCategory category = new EventCategory(newCategory, newDescription);
				(new CategoryService()).addCategory(category);
				WhatsOutUser wouser = (WhatsOutUser) request.getSession().getAttribute("wouser");
				EventCategoryService service = new EventCategoryService();
				EventCategory eventCategory = service.getEventCategoryBy(category.getName());
				SubscriptionService subscriptionService = new SubscriptionService();
				subscriptionService.addSubscription(new Subscription(LocalDate.now(), wouser, eventCategory));
				List<EventCategory> subscribedCategories = subscriptionService.getSubscribedCategories(wouser.getId());
				
				JSONObject[] arrEvent = new JSONObject[subscribedCategories.size()];
				int i = 0;
				for(EventCategory ec : subscribedCategories) {
					JSONObject res = new JSONObject();
					res.put("name", ec.getName());
					arrEvent[i] =res;
					i++;
				}
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(Arrays.toString(arrEvent));
				response.getWriter().flush();
				/*
				 * JSONObject[] arrEvent = new JSONObject[eventList.size()];
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
			response.getWriter().flush();*/
				//this.doGet(request, response);
				}
	}

}
