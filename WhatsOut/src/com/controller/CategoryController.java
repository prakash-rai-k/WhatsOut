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

import com.model.EventCategory;
import com.service.CategoryService;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Here" + request.getParameter("category"));
		String newCategory = request.getParameter("category");
//		System.out.println(newCategory);
//		String newDescription= request.getParameter("description");
		EventCategory category = new EventCategory();
		category.setName(newCategory);
//		System.out.println(category);
		CategoryService categoryService = new CategoryService();
		categoryService.addCategory(category);
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
