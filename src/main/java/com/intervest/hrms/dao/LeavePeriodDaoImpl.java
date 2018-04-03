package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.LeavePeriod;

@Repository
public class LeavePeriodDaoImpl implements LeavePeriodDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addLeavePeriod(LeavePeriod lp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(lp);

	}

	@Override
	public void updateLeavePeriod(LeavePeriod lp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(lp);

	}

	@Override
	public List<LeavePeriod> listLeavePeriods() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LeavePeriod> leavePeriods = session
				.createQuery("from LeavePeriod").list();
		return leavePeriods;
	}

	@Override
	public LeavePeriod getLeavePeriodById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLeavePeriod(int id) {
		// TODO Auto-generated method stub

	}

}
