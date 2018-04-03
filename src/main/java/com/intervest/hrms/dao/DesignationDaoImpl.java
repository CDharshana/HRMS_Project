package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.Designation;

@Repository
public class DesignationDaoImpl implements DesignationDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Designation> listDesignations() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Designation> designations = session
				.createQuery("from Designation").list();
		return designations;
	}

}
