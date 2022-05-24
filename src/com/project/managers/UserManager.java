package com.project.managers;

import com.project.dao.UserDao;
import com.project.entities.User;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();

// using singleton pattern
	private UserManager() {

	}

	public static UserManager getInstance() {

		return instance;

	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		return user;

	}
	
	
	public User[] getUsers() {
		return dao.getUsers();
	}

}
