package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from User where username = :username");
		query.setParameter("username", username);
		// query.setMaxResults(1);
		List<User> userList = query.list();
		if (userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub

	}

}
