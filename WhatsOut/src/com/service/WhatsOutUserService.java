package com.service;

import com.dao.WhatsOutUserDao;
import com.model.WhatsOutUser;

/**
*
* @author Rupendra MAHARJAN 
* Created On: March 20,2018 
* Description: Service related to User Information
*/
public class WhatsOutUserService {
	private WhatsOutUserDao userDao;
	
	public WhatsOutUserService() {
		userDao = new WhatsOutUserDao();
	}
	
	public WhatsOutUser getUserbyLogin(String username, String password) {
		return userDao.findBy(username, password);
	}
	
	public boolean registerUser(WhatsOutUser wouser) {
		return userDao.insert(wouser);
	}
	
	public WhatsOutUser getUserBy(String username) {
		return userDao.findBy(username);
	}
}
