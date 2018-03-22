package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.WhatsOutUser;
import com.service.WhatsOutUserService;

@WebServlet("/UserSetting")
public class SettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SettingController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String str = request.getParameter("errorMsg");
//		System.out.println(str);
		request.getServletContext().getRequestDispatcher("/views/settings/user_settings.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassword = request.getParameter("old-password");
		WhatsOutUser user = (WhatsOutUser) request.getSession(false).getAttribute("wouser");
		System.out.println("user: " + user.getPassword());
		String newPassword = request.getParameter("new-password");
		System.out.println("newPassword" +  newPassword);
		if(oldPassword.equals(user.getPassword())) {			
			String confirmPassword = request.getParameter("confirm-password");
			if(!newPassword.equals(confirmPassword)) {
				request.setAttribute("errorMsg", "New Password Confirmation Failed");
				request.getServletContext().getRequestDispatcher("/views/settings/user_settings.jsp").forward(request, response);
			}else {
				user.setPassword(newPassword);
				(new WhatsOutUserService()).updateProfile(user);
				request.setAttribute("errorMsg", "Password Successfully changed");
				request.getServletContext().getRequestDispatcher("/views/settings/user_settings.jsp").forward(request, response);		
			}
		}
		else {
			request.setAttribute("errorMsg", "Old Password Mismatch");
			this.getServletContext().getRequestDispatcher("/views/settings/user_settings.jsp").forward(request, response);
		}
	}

}
