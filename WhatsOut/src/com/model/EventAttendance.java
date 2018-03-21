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
	
	public EventAttendance() {
		
	}

	public EventAttendance(int id, LocalDate signDate) {
		super();
		this.id = id;
		this.signDate = signDate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((signDate == null) ? 0 : signDate.hashCode());
		return result;
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
		if (id != other.id)
			return false;
		if (signDate == null) {
			if (other.signDate != null)
				return false;
		} else if (!signDate.equals(other.signDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventAttendance [id=" + id + ", signDate=" + signDate + "]";
	}
}
