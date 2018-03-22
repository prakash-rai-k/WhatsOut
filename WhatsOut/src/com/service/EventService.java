/**
*
* @author Prakash 
* Created On: March 20,2018 
* Description: Event Service
*/

package com.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dao.EventDao;
import com.model.Event;
import com.model.WhatsOutUser;

public class EventService {
	EventDao eventDao = new EventDao();
	
	/*The following function retrieves the an event by its id Author Yvan*/
	public Event find(int eventID) {
		return eventDao.get(eventID);
	}
	//Get all events
	public List<Event> getAll(){
		return eventDao.all();
	}
	
	//Get all events
	public List<Event> getAll(int id){
		return eventDao.all(id);
	}
	
	//Get events by userId
	public List<Event> getEventsBy(WhatsOutUser user){
		return eventDao.findBy(user);
	}
	
	//Get events by userId
	public List<Event> getAttendedEventsBy(WhatsOutUser user){
		List<Event> events = eventDao.findBy(user);
		
		LocalDateTime curDateTime = LocalDateTime.now();
		for(Event event : events) {
			if(event.getHappeningOn().compareTo(curDateTime) > 0) {
				events.remove(event);
			}
		}
		
		return events;
	}
	
	//gets event by id
	public Event getEventBy(int id) {
		return eventDao.get(id);
	}
	
	//add new Event
	public boolean addNewEvent(Event event) {
		return eventDao.insert(event);
	}
}
