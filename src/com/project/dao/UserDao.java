package com.project.dao;

import com.project.entities.Bookmark;
import com.project.entities.User;
import com.project.socialbookmarking.DataStore;

public class UserDao {
	
	public User[] getUsers() {
		
		return DataStore.getUsers();
	}
	
	
}
 