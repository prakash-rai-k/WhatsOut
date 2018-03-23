package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.EventCategoryDao;
import com.dao.SubscriptionDao;
import com.model.EventCategory;
import com.model.Subscription;
/*
* Written On March 21, 2018
* Provides Service to the Subscription
* Uses DAO Created by Yvan GAKUBA
* @Author Prakash RAI
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
			if(!eventCatList.contains(subscription.getCategory())) {
				eventCatList.add(subscription.getCategory());
			}
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
	
	/*
	 * Delete all subscriptions
	 */
	
	public boolean deleteSubscription(Subscription s) {
		return(subscriptionDao.delete(s));
	}
	
	public List<Subscription> getSubscriptionList(int subscriberId){
		return subscriptionDao.get(subscriberId);
	}
	
}
