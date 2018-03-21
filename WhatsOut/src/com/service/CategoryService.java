package com.service;

import java.util.List;

import com.dao.EventCategoryDao;
import com.model.EventCategory;

public class CategoryService {
	private EventCategoryDao eventCategoryDao;

	public CategoryService() {
		eventCategoryDao=new EventCategoryDao();
	}

	public List<EventCategory> getCategoryList() {
		return eventCategoryDao.findAll();
	}
	
	public void addCategory(EventCategory category) {
		System.out.println("Category" + category);
		if(!this.getCategoryList().contains(category)) {			
			eventCategoryDao.insert(category);
		}
	}
	
	public List<EventCategory> getCategory(int id){
		return eventCategoryDao.findAll();
	}

}
