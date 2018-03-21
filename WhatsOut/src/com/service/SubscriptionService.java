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
* Created On: March 20,2018 
* Description: Event Service
*/

public class SubscriptionService {
	
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
}
