package com.bitwise.shop.models;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
	private List<User> usersList = new ArrayList<User>();
	
	public Users () {
		this.initUsers();
	}
	
	public void initUsers () {
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
