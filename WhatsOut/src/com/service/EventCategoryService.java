package com.service;

import com.dao.EventCategoryDao;
import com.model.EventCategory;

public class EventCategoryService {
	EventCategoryDao dao = new EventCategoryDao();
	
	/*
	* Written On March 21, 2018
	* Get Event Category By Event Id
	* Uses DAO Created by Yvan GAKUBA
	* @Author Prakash RAI
	*/
	public EventCategory getEventCategoryBy(int id) {
		return dao.findBy(id);
	}
	
	/*
	* Written On March 21, 2018
	* Get Event Category by Name
	* Uses DAO Created by Yvan GAKUBA
	* @Author Prakash RAI
	*/
	public EventCategory getEventCategoryBy(String name) {
		return dao.findBy(name);
	}
	
	
	
	
}
