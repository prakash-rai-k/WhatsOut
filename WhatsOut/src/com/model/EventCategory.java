package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rupendra MAHARJAN
 * Date: 03/19/2018
 * Description: EventCategory Information
 */

public class EventCategory {

	private int id;
	private String name;
	private String description;
	
	private List<Event> eventList =  new ArrayList<>();

	public EventCategory() {

	}

	public EventCategory(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addEvent(Event event) {
		eventList.add(event);
	}
	
	public List<Event> getEventList(){
		return eventList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EventCategory other = (EventCategory) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventCategory [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
