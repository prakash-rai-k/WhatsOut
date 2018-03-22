package com.service;

import com.dao.EventCategoryDao;
import com.model.EventCategory;

/**
*
* @author Prakash 
* Created On: March 20,2018 
* Description: Event category Service
*/

public class EventCategoryService {
	EventCategoryDao dao = new EventCategoryDao();
	
	//get eventcategory by id
	public EventCategory getEventCategoryBy(int id) {
		return dao.findBy(id);
	}
}
