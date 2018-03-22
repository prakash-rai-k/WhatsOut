package com.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.model.Event;
import com.model.EventAttendance;
import com.model.WhatsOutUser;
import com.service.EventAttendanceService;
import com.service.EventService;

@WebServlet("/AttendanceController")
public class AttendanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AttendanceController() {
		super();
	}

	/*
	 * Author: Yvan GAKUBA doGet method receives a requet from attendance.js(AJAX)
	 * of the event ID and adds the the user in session in the attendance list. It
	 * uses a service written by Yvan GAKUBA on March 21, 2018
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EventAttendanceService eas = new EventAttendanceService();
		WhatsOutUser user = (WhatsOutUser) request.getSession().getAttribute("wouser");
		if (user != null) {
			Event event = new EventService().find(Integer.parseInt(request.getParameter("id")));
			EventAttendance ea = new EventAttendance();
			ea.setEvent(event);
			ea.setSignDate(LocalDate.now());
			ea.setUser(user);
			System.out.println(ea);
			user.addEventAttendance(ea);
			JSONObject res = new JSONObject();
			if (eas.isAttending(ea)) {
				eas.removeAttendant(ea);
				res.put("Message", " Count Me!");
			} else {
				eas.addAttendant(ea);
				res.put("Message", " Attending!");
			}
			System.out.println(eas.getAttendanceListByEvent(event.getId()).size());
			res.put("nbr", eas.getAttendanceListByEvent(event.getId()).size());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(res);
			response.getWriter().flush();
		}
	}

}
