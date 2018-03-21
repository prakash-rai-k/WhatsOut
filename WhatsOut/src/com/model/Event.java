package com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Rupendra MAHARJAN
* Created Date: March 19, 2018
* Description: Event Information
*/
public class Event {
	
	private int id;
	private String title;
	private String description;
	private String logo;
	private LocalDateTime createdOn;
	private LocalDateTime happeningOn;
	private LocalDateTime endingOn;
	private int capacity;
	private Address address;
	private EventCategory eventCategory;
	private WhatsOutUser eventCreator;
	private List<Comment> commentList;
	private List<Rating> ratingList;
	private List<EventAttendance> eventAttendanceList;
	
	public Event() {
		this.commentList = new ArrayList<>();
		this.ratingList = new ArrayList<>();
		this.eventAttendanceList = new ArrayList<>();
	}
	
	public Event(int id, String title, String description, String logo, LocalDateTime createdOn,
			LocalDateTime happeningOn, LocalDateTime endingOn, int capacity, Address address,
			EventCategory eventCategory, WhatsOutUser eventCreator) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.logo = logo;
		this.createdOn = createdOn;
		this.happeningOn = happeningOn;
		this.endingOn = endingOn;
		this.capacity = capacity;
		this.address = address;
		this.eventCategory = eventCategory;
		this.eventCreator = eventCreator;
		this.commentList = new ArrayList<>();
		this.ratingList = new ArrayList<>();
		this.eventAttendanceList = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getHappeningOn() {
		return happeningOn;
	}
	public void setHappeningOn(LocalDateTime happeningOn) {
		this.happeningOn = happeningOn;
	}
	public LocalDateTime getEndingOn() {
		return endingOn;
	}
	public void setEndingOn(LocalDateTime endingOn) {
		this.endingOn = endingOn;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public EventCategory getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(EventCategory eventCategory) {
		this.eventCategory = eventCategory;
	}
	public WhatsOutUser getEventCreator() {
		return eventCreator;
	}
	public void setEventCreator(WhatsOutUser eventCreator) {
		this.eventCreator = eventCreator;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}
	public List<EventAttendance> getEventAttendanceList() {
		return eventAttendanceList;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", logo=" + logo
				+ ", createdOn=" + createdOn + ", happeningOn=" + happeningOn + ", endingOn=" + endingOn + ", capacity="
				+ capacity + ", address=" + address + ", eventCategory=" + eventCategory + ", eventCreator="
				+ eventCreator + "]";
	}
	
	
}
