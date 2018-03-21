/**
*
* @author Prakash 
* Created On: March 20,2018 
* Description: Event Service
*/

package com.service;

import java.util.List;

import com.dao.EventDao;
import com.model.Event;
import com.model.WhatsOutUser;

public class EventService {
	EventDao eventDao = new EventDao();
	
	//Get all events
	public List<Event> getAll(){
		return eventDao.all();
	}
	
	//Get events by userId
	public List<Event> getEventsBy(WhatsOutUser user){
		return eventDao.findBy(user);
	}
}
