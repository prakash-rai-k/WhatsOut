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
//		System.out.println(addressService.getStateList());
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
		List<String> categoryList = categoryService.getCategoryList().stream().map(list -> list.getName())
				.collect(Collectors.toList());
//		System.out.println("All Categories:" + categoryList);
		request.setAttribute("categoryList", categoryList);
		List<String> subscriptionList = woUser.getSubscriptionList().stream().map(list -> list.getCategory().getName())
				.collect(Collectors.toList());
//		System.out.println("SubscriptionList: " + subscriptionList);
		request.setAttribute("subscriptionList", subscriptionList);
		request.getServletContext().getRequestDispatcher("/views/profile/profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		List<String> interests = Arrays.asList(choices.split("%%%%%"));
		System.out.println(interests);
		WhatsOutUser woUser = getActiveUser(request, response);

		WhatsOutUser modifiedUser = new WhatsOutUser(woUser.getId(), woUser.getUserName(), woUser.getPassword(),
				firstName, lastName, middleName, email, phone, woUser.getProfilePicture(), woUser.getJoinDate(),
				newAddress);
		WhatsOutUserService userService = new WhatsOutUserService();
		userService.updateProfile(modifiedUser);

		SubscriptionService subscriptionService = new SubscriptionService();
		CategoryService categoryService = new CategoryService();
		List<EventCategory> categoryList = categoryService.getCategoryList();
		List<String> subscriptionList = modifiedUser.getSubscriptionList().stream()
				.map(list -> list.getCategory().getName()).collect(Collectors.toList());
		for (EventCategory category : categoryList) {
			if (interests.contains(category.getName()) && !subscriptionList.contains(category)) {
//				subscriptionService.addSubscription(new Subscription(LocalDate.now(), modifiedUser, category));
			}
		}
	}

	public WhatsOutUser getActiveUser(HttpServletRequest request, HttpServletResponse response) {
		String username = (String) request.getSession(false).getAttribute("username");
		String password = (String) request.getSession(false).getAttribute("password");
		WhatsOutUser woUser = (new WhatsOutUserService()).getUserbyLogin(username, password);
		return woUser;
	}

}
