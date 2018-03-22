package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddressDao;
import com.model.Address;
import com.model.EventCategory;
import com.model.Subscription;
import com.model.WhatsOutUser;
import com.service.AddressService;
import com.service.CategoryService;
import com.service.EventService;
import com.service.SubscriptionService;
import com.service.WhatsOutUserService;

/*
 * @Author Rupendra MAHARJAN
 * Date: March 21, 2018
 * Profile pages
 */

@WebServlet("/Profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to login if there is no usersession
		if (request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		} else {
			WhatsOutUser woUser = getActiveUser(request, response);
			if (woUser.getMiddleName().isEmpty()) {
				request.setAttribute("fullname", woUser.getFirstName() + " " + woUser.getLastName());
			} else {
				request.setAttribute("fullname",
						woUser.getFirstName() + " " + woUser.getMiddleName() + " " + woUser.getLastName());
			}
			AddressService addressService = new AddressService();

			// State List to Upload the DropDown List
			request.setAttribute("stateList", addressService.getStateList());
			String currentState = woUser.getAddress().getState();

			// Displays users current State
			request.setAttribute("currentState", woUser.getAddress().getState());
			List<String> cityList = addressService.getAddressListByState(currentState).stream()
					.map(address -> address.getCity()).collect(Collectors.toList());

			// City List to Upload the DropDown List
			request.setAttribute("cityList", cityList);
			// Displays users current City
			request.setAttribute("currentCity", woUser.getAddress().getCity());
			request.setAttribute("email", woUser.getEmail());
			request.setAttribute("phone", woUser.getPhone());
			CategoryService categoryService = new CategoryService();

			List<String> categoryList = categoryService.getCategoryList().stream()
					.map(list -> list.getName().toString()).collect(Collectors.toList());
			System.out.println("All Categories:" + categoryList);
			request.setAttribute("categoryList", categoryList);

			SubscriptionService subscriptionService = new SubscriptionService();
			List<String> subscriptionList = subscriptionService.getSubscriptionList(woUser.getId()).stream()
					.map(list -> list.getCategory().getName().toString()).distinct().collect(Collectors.toList());
			System.out.println("SubscriptionList: " + subscriptionList);
			request.setAttribute("subscriptionList", subscriptionList);
			
			WhatsOutUser wouser = (WhatsOutUser) request.getSession().getAttribute("wouser");
			EventService eventService = new EventService();
			//SubscriptionService subscriptionService = new SubscriptionService();
			//AddressService addressService = new AddressService();
			
			//List all subscribed categories
			//List<String> subscriptionList = wouser.getSubscriptionList().stream()
				//	.map(list -> list.getCategory().getName().toString()).distinct().collect(Collectors.toList());
			List<EventCategory> subscribedCategories = subscriptionService.getSubscribedCategories(wouser.getId());
			List<EventCategory> categories = subscriptionService.getEventCategories();
			List<String> states = addressService.getStateList();
			List<String> cities = addressService.getCities(wouser.getAddress().getState());
			
			for(EventCategory ss : subscribedCategories) {
				System.out.println(ss);
			}
			//Adding categories subscribed by logged in user
			//Adding events list related to user
			System.out.println(subscribedCategories.size());
			request.setAttribute("subscriptionList", subscriptionList);
	    	request.setAttribute("categoryList", subscribedCategories);
	    	request.setAttribute("events", eventService.getAll(wouser.getId()));
	    	request.setAttribute("states", states);
	    	request.setAttribute("cities", cities);
	    	request.setAttribute("userState", wouser.getAddress().getState());
	    	request.setAttribute("userCity", wouser.getAddress().getCity());
	    	request.setAttribute("categories", categories);
			request.getServletContext().getRequestDispatcher("/views/profile/profile.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to login if there is no usersession
		if (request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		} else {
			String fullName = request.getParameter("fullname");
			String[] names = fullName.split("\\s");
			String firstName = "";
			String middleName = "";
			String lastName = "";
			if (names.length == 1) {
				firstName = names[0];
			} else if (names.length == 2) {
				firstName = names[0];
				lastName = names[1];
			} else {
				firstName = names[0];
				lastName = names[names.length - 1];
				for (int i = 1; i < names.length - 1; ++i) {
					middleName += names[i];
				}
			}
			String email = request.getParameter("email");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String phone = request.getParameter("phone");
			Address newAddress = (new AddressDao()).findBy(state, city);
			String choices = request.getParameter("choiceArray");
			choices = choices.substring(0, choices.length() - 1);
			List<String> interests = Arrays.asList(choices.split(","));
			
			System.out.println(interests);
			WhatsOutUser woUser = getActiveUser(request, response);
			WhatsOutUser modifiedUser = new WhatsOutUser(woUser.getId(), woUser.getUserName(), woUser.getPassword(),
					firstName, lastName, middleName, email, phone, woUser.getProfilePicture(), woUser.getJoinDate(),
					newAddress);
			WhatsOutUserService userService = new WhatsOutUserService();

			SubscriptionService subscriptionService = new SubscriptionService();
			CategoryService categoryService = new CategoryService();
			List<EventCategory> categoryList = categoryService.getCategoryList();
			List<Subscription> subscriptionList = woUser.getSubscriptionList();

			for (Subscription s : subscriptionList) {
				subscriptionService.deleteSubscription(s);
			}
			for (EventCategory category : categoryList) {
				if (interests.contains(category.getName())) {
					subscriptionService.addSubscription(new Subscription(LocalDate.now(), woUser, category));
				}
			}
			userService.updateProfile(modifiedUser);
			request.getSession(false).setAttribute("wouser", modifiedUser);
		}
	}

	public WhatsOutUser getActiveUser(HttpServletRequest request, HttpServletResponse response) {
		WhatsOutUser woUser = (WhatsOutUser) request.getSession(false).getAttribute("wouser");
		return woUser;
	}

}
