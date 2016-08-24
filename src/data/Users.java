package data;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class Users {
	List<User> users = new ArrayList<User>();

	public Users() {
		users.add(new User("gaurav", "Gaurav@123"));
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
