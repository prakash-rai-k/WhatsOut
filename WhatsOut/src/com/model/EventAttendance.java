package com.model;

import java.time.LocalDate;

/**
*
* @author Rupendra MAHARJAN
* Created On: March 19, 2018
* Description: Event Attended By WhatsOutUser
*/
public class EventAttendance {
	private int id;
	private LocalDate signDate;
	private WhatsOutUser user;
	private Event event;


	public EventAttendance() {
		this.event=new Event();
		this.user=new WhatsOutUser();
	}

	public EventAttendance(int id, LocalDate signDate, WhatsOutUser user, Event event) {
		super();
		this.id = id;
		this.signDate = signDate;
		this.user = user;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getSignDate() {
		return signDate;
	}

	public void setSignDate(LocalDate signDate) {
		this.signDate = signDate;
	}

	public WhatsOutUser getUser() {
		return user;
	}

	public void setUser(WhatsOutUser user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventAttendance other = (EventAttendance) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		if (signDate == null) {
			if (other.signDate != null)
				return false;
		} else if (!signDate.equals(other.signDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user)) 
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventAttendance [id=" + id + ", signDate=" + signDate + ", user=" + user + ", event=" + event + "]";
	}

	
}
