package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.User;

public interface UserDao {
	public User addUser(User user);

	public void updateUser(User user);

	public List<User> listUsers();

	public User getUserByUsername(String username);

	public void removeUser(int id);
}
