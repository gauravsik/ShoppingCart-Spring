package com.bitwise.shop.models;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.shop.models.User;

public class Users {
	
	private List<User> usersList = new ArrayList<User>();
	
	public Users () {
		usersList.add(new User("gaurav", "Gaurav@123"));
		usersList.add(new User("varun", "Varun@456"));
		usersList.add(new User("tarun", "Tarun@789"));
		usersList.add(new User("simranjit", "Simran@987"));
		usersList.add(new User("saurabh", "Saurabh@654"));
	}
	
	public List<User> getUsers () {
		return this.usersList;
	}
}
