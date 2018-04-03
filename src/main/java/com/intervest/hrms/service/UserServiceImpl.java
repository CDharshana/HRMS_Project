package com.intervest.hrms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.UserDao;
import com.intervest.hrms.model.User;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public User addUser(User user) {
		return this.userDao.addUser(user);
	}

	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return this.userDao.getUserByUsername(username);
	}

}
