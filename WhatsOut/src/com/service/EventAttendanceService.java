package com.service;

import java.util.List;

import com.dao.EventAttendanceDao;
import com.model.EventAttendance;
/**
 *
 * @author Yvan GAKUBA 
 * Created On: March 21, 2018 
 * Description: Service to manage the event Attendance.
 */
public class EventAttendanceService {
	/*
	 * Written on March 21, 2018 
	 * This function creates an attendance to an event
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public boolean addAttendant(EventAttendance ea) {
		return new EventAttendanceDao().insert(ea);
	}
	/*
	 * Written on March 21, 2018 
	 * This function removes a user from attendance list
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public boolean removeAttendant(EventAttendance ea) {
		return new EventAttendanceDao().delete(ea);
	}
	/*
	 * Written on March 21, 2018 
	 * This function checks if a user is attending
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public boolean isAttending(EventAttendance ea) {
		return new EventAttendanceDao().isAttending(ea.getEvent().getId(), ea.getUser().getId());
	}
	/*
	 * Written on March 21, 2018 
	 * This function return the attendance list of a particula Event
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public List<EventAttendance> getAttendanceListByEvent(int eventID) {
		return new EventAttendanceDao().findBy(eventID);
	}
	
	/*
	 * Written on March 21, 2018 
	 * This function return the attendance list of a particula Event
	 * Uses the EventAttendanceDao created by Yvan GAKUBA on  March 21, 2018 
	 * @Author Yvan GAKUBA
	 * */
	public List<EventAttendance> getAttendanceListByUser(int userId) {
		return new EventAttendanceDao().get(userId);
	}
}
