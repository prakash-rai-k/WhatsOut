package com.service;

import java.util.List;

import com.dao.EventCategoryDao;
import com.model.EventCategory;

public class CategoryService {
	private EventCategoryDao eventCategoryDao;

	public CategoryService() {
		eventCategoryDao=new EventCategoryDao();
	}

	/*
	* Written On March 20, 2018
	* Get List of All Categories
	* Uses DAO Created by Yvan GAKUBA
	* @Author Rupendra MAHARJAN
	*/
	public List<EventCategory> getCategoryList() {
		return eventCategoryDao.findAll();
	}
	/*
	* Written On March 20, 2018
	* Adds Category entered by user to the database 
	* Uses DAO Created by Yvan GAKUBA
	* @Author Rupendra MAHARJAN
	*/
	public void addCategory(EventCategory category) {
		System.out.println("Category" + category);
		if(!this.getCategoryList().contains(category)) {			
			eventCategoryDao.insert(category);
		}
	}
	
	/*
	* Written On March 20, 2018
	* Get List of Categories based on Category Id
	* Uses DAO Created by Yvan GAKUBA
	* @Author Prakash RAI
	*/
	public List<EventCategory> getCategory(int id){
		return eventCategoryDao.findAll();
	}

}
