package com.service;

import com.dao.SubscriptionDao;
import com.dao.WhatsOutUserDao;
import com.model.Subscription;
import com.model.WhatsOutUser;

/**
*
* @author Rupendra MAHARJAN 
* Created On: March 20,2018 
* Description: Service related to User Information
*/
public class WhatsOutUserService {
	private WhatsOutUserDao userDao;
	private SubscriptionDao sDao;

	public WhatsOutUserService() {
		userDao = new WhatsOutUserDao();
		sDao = new SubscriptionDao();
	}
	
	public WhatsOutUser getUserbyLogin(String username, String password) {
		WhatsOutUser user = userDao.findBy(username, password);
		for (Subscription s : sDao.get(user.getId())) {
			user.addSubscription(s);
		}
		return user;
	}

	public boolean registerUser(WhatsOutUser wouser) {
		return userDao.insert(wouser);
	}
	
	public boolean updateProfile(WhatsOutUser user) {
		return userDao.update(user);
	}
	

	public WhatsOutUser getUserBy(String username) {
		return userDao.findBy(username);
	}
}
