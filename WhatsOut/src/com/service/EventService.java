/**
*
* @author Prakash 
* Created On: March 20,2018 
* Description: Event Service
*/

package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dao.EventAttendanceDao;
import com.dao.EventDao;
import com.model.Event;
import com.model.EventAttendance;
import com.model.EventCategory;
import com.model.WhatsOutUser;

public class EventService {
	EventDao eventDao = new EventDao();

	/* The following function retrieves the an event by its id Author Yvan */
	public Event find(int eventID) {
		return eventDao.get(eventID);
	}

	// Get all events
	public List<Event> getAll() {
		return eventDao.all();
	}

	// Get all events
	public List<Event> getAll(int id) {
		return eventDao.all(id);
	}

	// Get events by userId
	public List<Event> getEventsBy(WhatsOutUser user) {
		return eventDao.findBy(user);
	}

	// Get events by userId
	public List<Event> getAttendedEventsBy(WhatsOutUser user) {
		List<Event> eventAttended = new ArrayList<Event>();
		EventAttendanceService attendanceService = new EventAttendanceService();
		List<EventAttendance> eventAttendances = attendanceService.getAttendanceListByUser(user.getId());
		LocalDateTime curDateTime = LocalDateTime.now();

		for (EventAttendance ea : eventAttendances) {
			if (eventDao.get(ea.getEvent().getId()).getHappeningOn().compareTo(curDateTime) > 0) {
				eventAttended.add(eventDao.get(ea.getEvent().getId()));
			}
		}

		return eventAttended;
	}

	// Get events by userId
	public List<Event> getAtteningEventsBy(WhatsOutUser user) {
		List<Event> eventAttended = new ArrayList<Event>();
		EventAttendanceService attendanceService = new EventAttendanceService();
		List<EventAttendance> eventAttendances = attendanceService.getAttendanceListByUser(user.getId());
		LocalDateTime curDateTime = LocalDateTime.now();

		for (EventAttendance ea : eventAttendances) {
			if (eventDao.get(ea.getEvent().getId()).getHappeningOn().compareTo(curDateTime) < 0) {
				eventAttended.add(eventDao.get(ea.getEvent().getId()));
			}
		}

		return eventAttended;
	}

	// Search events in title, state, city, state and description
	public List<Event> searchEvent(String searchString) {
		List<Event> allEventList = getAll();
		List<Event> eventList = new ArrayList<Event>();
		for (Event event : allEventList) {
			if (event.getTitle().toLowerCase().contains(searchString.toLowerCase())
					|| event.getAddress().getCity().toLowerCase().contains(searchString.toLowerCase())
					|| event.getAddress().getState().toLowerCase().contains(searchString.toLowerCase())
					|| event.getDescription().toLowerCase().contains(searchString.toLowerCase())) {
				eventList.add(event);
			}
		}

		return eventList;
	}
	
	//get event based on interest of user
	public List<Event> getInterestedEventsBy(WhatsOutUser user) {
		List<Event> eventAttended = new ArrayList<Event>();
		SubscriptionService subscriptionService = new SubscriptionService();
		List<EventCategory> eventCategories = subscriptionService.getSubscribedCategories(user.getId());
		for (EventCategory ec : eventCategories) {
			eventAttended.addAll(eventDao.findBy(ec.getId()));
		}
		return eventAttended;
	}

	// gets event by id
	public Event getEventBy(int id) {
		return eventDao.get(id);
	}

	// add new Event
	public boolean addNewEvent(Event event) {
		return eventDao.insert(event);
	}
	
	/*This function checks if the user is attending the event or not
	 * Added by Yvan GAKUBA
	 * Uses isAttending() function in EventendanceDao written by Yvan GAKUBA ON March 20, 2018
	 * */
	public boolean isUserAttending(int eventID, int userID) {
		return new EventAttendanceDao().isAttending(eventID, userID);
	}
}
