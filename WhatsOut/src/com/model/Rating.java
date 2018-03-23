package com.model;

/*
* Written On March 20, 2018
* Event Attended By WhatsOutUser
* Designed by Yvan GAKUBA and Prakash RAI
* @Author Yvan GAKUBA
*/

public class Rating {
	private int id;
	private int value;
	private WhatsOutUser user;
	private Event event;

	public Rating() {
		this.event=new Event();
		this.user=new WhatsOutUser();
	}

	public Rating(int id, int value,WhatsOutUser user, Event event) {
		super();
		this.id = id;
		this.value = value;
		this.event=new Event();
		this.user=new WhatsOutUser();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
		Rating other = (Rating) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", value=" + value + "]";
	}
	
}
