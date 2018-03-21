package com.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.dao.AddressDao;
import com.dao.EventCategoryDao;
import com.dao.EventDao;
import com.dao.SubscriptionDao;
import com.dao.WhatsOutUserDao;
import com.model.Address;
import com.model.Event;
import com.model.EventCategory;
import com.model.Subscription;
import com.model.WhatsOutUser;

/**
 *
 * @author Yvan GAKUBA
 */
public class DBConnectionTest {
	public static void main(String[] args) {
		EventCategory e=new EventCategoryDao().findBy("ART");
		WhatsOutUser whatsOutUser=new WhatsOutUserDao().findBy(1);
		Subscription s=new Subscription();
		s.setCategory(e);
		s.setSubscriber(whatsOutUser);
		s.setSubscriptionDate(LocalDate.now());
		System.out.println(new SubscriptionDao().get(1));
		Address a=new AddressDao().findBy("IOWA","Fairfield");
		Event ev=new Event();
		ev.setId(1);
		ev.setAddress(a);
		ev.setCapacity(240);
		ev.setCreatedOn(LocalDateTime.now());
		ev.setHappeningOn(LocalDateTime.now());
		ev.setEndingOn(LocalDateTime.now());
		ev.setEventCategory(e);
		ev.setEventCreator(whatsOutUser);
		ev.setLogo("default.png");
		ev.setTitle("Fairfield Arts & Convention Center");
		ev.setDescription("\r\n" + 
				"the expression or application of human creative skill and imagination, typically in a visual form such as painting or sculpture, producing works to be appreciated primarily for their beauty or emotional power.");
		System.out.println(new EventDao().update(ev));
		
//		EventCategory ec=new EventCategory();
//		ec.setId(1);
//		ec.setName("ART");
//		ec.setDescription("creative skill and imagination, typically in a visual form such as painting or sculpture, producing works to be appreciated primarily for their beauty or emotional power.");
//		System.out.println(new EventCategoryDao().update(ec));
		//		WhatsOutUserDao wdao=new WhatsOutUserDao();
//		System.out.println(wdao.findBy("gakyvan", "password15380"));
//		AddressDao adao=new AddressDao();
//		Address a=adao.findBy("IOWA","Fairfield");
//		WhatsOutUserDao wdao=new WhatsOutUserDao();
//		WhatsOutUser whatsOutUser=new WhatsOutUser();
//		whatsOutUser.setUserName("gakyvan");
//		whatsOutUser.setPassword("p");
//		whatsOutUser.setFirstName("Yvan");
//		whatsOutUser.setLastName("GAKUBA");
//		whatsOutUser.setMiddleName("Florian");
//		whatsOutUser.setEmail("ygakuba@mum.edu");
//		whatsOutUser.setPhone("+1(641)980-4138");
//		whatsOutUser.setProfilePicture("default.png");
//		whatsOutUser.setAddress(a);
//		whatsOutUser.setJoinDate(LocalDate.now());
//		System.out.println(wdao.update(whatsOutUser));
		
	}
}
