package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Rupendra MAHARJAN
* Created On: March 19, 2018
* Description: WhatsOutUser Information
*/

public class WhatsOutUser {
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String phone;
	private String profilePicture;
	private LocalDate joinDate;
	private Address address;
	private List<EventAttendance> eventAttendanceList;
	private List<Event> createdEventList;
	private List<Subscription> subscriptionList;

	public WhatsOutUser() {
		this.eventAttendanceList = new ArrayList<>();
		this.createdEventList = new ArrayList<>();
		this.subscriptionList = new ArrayList<>();
	}

	public WhatsOutUser(int id, String userName, String password, String firstName, String lastName, String middleName, String email,
			String phone, String profilePicture, LocalDate joinDate, Address address) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.email = email;
		this.phone = phone;
		this.profilePicture = profilePicture;
		this.joinDate = joinDate;
		this.address = address;
		this.eventAttendanceList = new ArrayList<>();
		this.createdEventList = new ArrayList<>();
		this.subscriptionList = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void addSubscription(Subscription subscription) {
		subscriptionList.add(subscription);
	}
	
	public List<Subscription> getSubscriptionList(){
		return subscriptionList;
	}
	
	public void addCreatedEvent(Event evnt) {
		createdEventList.add(evnt);
	}
	
	
	public List<Event> getCreatedEventList(){
		return createdEventList;
	}
	
	public void addEventAttendance(EventAttendance eventAttend) {
		this.eventAttendanceList.add(eventAttend);
	}
	
	public List<EventAttendance> getEventAttendance() {
		return eventAttendanceList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		WhatsOutUser other = (WhatsOutUser) obj;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WhatsOutUser [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", middleName=" + middleName + ", email=" + email + ", phone=" + phone
				+ ", profilePicture=" + profilePicture + ", joinDate=" + joinDate + ", address=" + address + "]";
	}
}
