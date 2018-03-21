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

import com.model.Address;
import com.service.AddressService;

@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddressController() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state = request.getParameter("state");
		AddressService addressService = new AddressService();
		List<Address> addressList = addressService.getAddressListByState(state);
		JSONObject[] arrAddress = new JSONObject[addressList.size()];
		for (int i = 0; i < addressList.size(); ++i) {
			if (addressList.get(i).getState().equals(state)) {
				JSONObject res = new JSONObject();
				res.put("state", addressList.get(i).getState());
				res.put("city", addressList.get(i).getCity());
				arrAddress[i] = res;
			}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(Arrays.toString(arrAddress));
		response.getWriter().flush();
	}
}
