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
 * Written on March 21, 2018
 * Acts on Profile Page and allows the user to modify the page
 * @Author Rupendra MAHARJAN
 */

@WebServlet("/Profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileController() {
		super();
	}

	/*
	 * Written on March 19, 2018
	 * Gets the details of users and publish them in the page at the beginning
	 * Uses the session created on LoginController
	 * Uses the AddressService, CategoryService, SubscriptionService and Event Service
	 * @Author Rupendra MAHARJAN
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to login if there is no usersession
		if (request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		} else {
			WhatsOutUser woUser = getActiveUser(request, response);
			
			/* 
			 * Process the first, middle and last name into a single full name
			 * */
			if (woUser.getMiddleName().isEmpty()) {
				request.setAttribute("fullname", woUser.getFirstName() + " " + woUser.getLastName());
			} else {
				request.setAttribute("fullname",
						woUser.getFirstName() + " " + woUser.getMiddleName() + " " + woUser.getLastName());
			}

			/*
			 * State List to Upload the DropDown List
			 * */
			AddressService addressService = new AddressService();
			request.setAttribute("stateList", addressService.getStateList());
			String currentState = woUser.getAddress().getState();

			/* 
			 * Displays user's current State
			 * */
			request.setAttribute("currentState", woUser.getAddress().getState());
			List<String> cityList = addressService.getAddressListByState(currentState).stream()
					.map(address -> address.getCity()).collect(Collectors.toList());

			/*
			 * City List to Upload the DropDown List
			 * */
			request.setAttribute("cityList", cityList);
			/*
			 * Displays user's current City
			 * */
			request.setAttribute("currentCity", woUser.getAddress().getCity());
			request.setAttribute("email", woUser.getEmail());
			request.setAttribute("phone", woUser.getPhone());
			CategoryService categoryService = new CategoryService();

			List<String> categoryList = categoryService.getCategoryList().stream()
					.map(list -> list.getName().toString()).collect(Collectors.toList());
			request.setAttribute("categoryList", categoryList);

			SubscriptionService subscriptionService = new SubscriptionService();
			List<String> subscriptionList = subscriptionService.getSubscriptionList(woUser.getId()).stream()
					.map(list -> list.getCategory().getName().toString()).distinct().collect(Collectors.toList());
			request.setAttribute("subscriptionList", subscriptionList);
			request.getServletContext().getRequestDispatcher("/views/profile/profile.jsp").forward(request, response);
		}
	}
	
	/*
	 * Written on March 21, 2018
	 * Receives data from the user and processes it to update user database.
	 * Uses the model WhatsOutUser, EventCategory and Subscription created on March 19, 2018
	 * Uses WhatsOutUserService, SubscriptionService and CategoryService
	 * @Author Rupendra MAHARJAN  
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to login if there is no usersession
		if (request.getSession().getAttribute("wouser") == null) {
			response.sendRedirect("/WhatsOut/Login");
		} else {
			
			/*
			 * Processes the full name and converts them into first, middle and last name
			 * */
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
			/* 
			 * Ends the full name processing 
			 * */
			
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

			/* 
			 * Adds the subscription to the user's subscription list
			 * */
			for (Subscription s : subscriptionList) {
				subscriptionService.deleteSubscription(s);
			}
			for (EventCategory category : categoryList) {
				if (interests.contains(category.getName())) {
					subscriptionService.addSubscription(new Subscription(LocalDate.now(), woUser, category));
				}
			}
			
			/*
			 *  Ends the addition of subscription process
			 *  */
			userService.updateProfile(modifiedUser);
			request.getSession(false).setAttribute("wouser", modifiedUser);
		}
	}

	/* 
	 * Returns the current user in the session
	 * */
	public WhatsOutUser getActiveUser(HttpServletRequest request, HttpServletResponse response) {
		WhatsOutUser woUser = (WhatsOutUser) request.getSession(false).getAttribute("wouser");
		return woUser;
	}

}
