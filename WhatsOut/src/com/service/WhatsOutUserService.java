package com.service;

import com.dao.SubscriptionDao;
import com.dao.WhatsOutUserDao;
import com.model.Subscription;
import com.model.WhatsOutUser;
/*
* Written On March 19, 2018
* Get Event Category By Event Id
* Uses DAO Created by Yvan GAKUBA
* @Author Rupendra MAHARJAN
*/
public class WhatsOutUserService {
	private WhatsOutUserDao userDao;
	private SubscriptionDao sDao;

	public WhatsOutUserService() {
		userDao = new WhatsOutUserDao();
		sDao = new SubscriptionDao();
	}
	
	//Returns User based on Username and Password
	public WhatsOutUser getUserbyLogin(String username, String password) {
		WhatsOutUser user = userDao.findBy(username, password);
		for (Subscription s : sDao.get(user.getId())) {
			user.addSubscription(s);
		}
		return user;
	}

	//Registers newly Signed Up User
	public boolean registerUser(WhatsOutUser wouser) {
		return userDao.insert(wouser);
	}
	
	//Updates the profile of the user based on entries made on Profile page
	public boolean updateProfile(WhatsOutUser user) {
		return userDao.update(user);
	}
	

	public WhatsOutUser getUserBy(String username) {
		return userDao.findBy(username);
	}
}
