package com.intervest.hrms.service;

import com.intervest.hrms.model.User;

public interface UserService {
	public User addUser(User user);

	public User getUserByUsername(String username);

}
