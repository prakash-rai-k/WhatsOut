package com.model;

import java.time.LocalDate;


/**
*
* @author Rupendra MAHARJAN
* Date: 03/19/2018
* Description: EventCategory Information
*/

public class Subscription {
	
	private int id;
	private LocalDate subscriptionDate;
	private WhatsOutUser subscriber;
	private EventCategory category;
	
	public Subscription() {}
	
	public Subscription(int id, LocalDate subscriptionDate, WhatsOutUser subscriber, EventCategory category) {
		super();
		this.id = id;
		this.subscriptionDate = subscriptionDate;
		this.subscriber = subscriber;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public WhatsOutUser getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(WhatsOutUser subscriber) {
		this.subscriber = subscriber;
	}
	public EventCategory getCategory() {
		return category;
	}
	public void setCategory(EventCategory category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (subscriptionDate == null) {
			if (other.subscriptionDate != null)
				return false;
		} else if (!subscriptionDate.equals(other.subscriptionDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", subscriptionDate=" + subscriptionDate + ", subscriber=" + subscriber
				+ ", category=" + category + "]";
	}
	
	
}
