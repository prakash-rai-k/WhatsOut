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

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {
		super();
	}

	/*Written on March 19, 2018
	 * Uses CategoryService method created on March 19, 2018
	 * Returns the JSON object for event categories
	 * @Author Rupendra MAHARJAN
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

	/* Written on March 19, 2018
	 * Inserts new category inserted by the user into the database
	 * and into the subscription database
	 * Uses EventCategoryService created on March 19, 2018
	 * @Author Rupendra MAHARJAN 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// redirect to login if there is no usersession
		if (request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		} else {
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
		}
	}

}
