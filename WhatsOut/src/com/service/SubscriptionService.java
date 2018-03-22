package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.EventCategoryDao;
import com.dao.SubscriptionDao;
import com.model.EventCategory;
import com.model.Subscription;
/**
*
* @author Prakash 
* Created On: March 21,2018 
* Description: Event controller
*/


public class SubscriptionService {
	private SubscriptionDao subscriptionDao;
	
	public SubscriptionService() {
		subscriptionDao = new SubscriptionDao();
	}
	
	/*
	 * Get categories subscribed by the user
	 * Parameters : userId
	 * Returns : list of Subscribed categories
	 * */
	public List<EventCategory> getSubscribedCategories(int userId){
		SubscriptionDao subscriptionDao = new SubscriptionDao();
		List<Subscription> subscriptions = subscriptionDao.get(userId);
		EventCategoryDao eventCatDao = new EventCategoryDao();
		List<EventCategory> eventCatList = new ArrayList<EventCategory>();
		
		for(Subscription subscription : subscriptions) {
			eventCatList.add(eventCatDao.findBy(subscription.getSubscriber().getId()));
		}
		
		return eventCatList;
		
	}
	
	/*
	 * Get all categories 
	 * Returns : list of Subscribed categories
	 * */
	public List<EventCategory> getEventCategories(){
		EventCategoryDao dao = new EventCategoryDao();
		return dao.findAll();
		
	}
	
	/*Add new subscription
	 * */
	public void addSubscription(Subscription s) {
		subscriptionDao.insert(s);
	}
	
	
	/*Update new subscription
	 * */
	public void updateSubscription(Subscription s) {
		System.out.println(subscriptionDao.update(s));
	}
	
	
}
