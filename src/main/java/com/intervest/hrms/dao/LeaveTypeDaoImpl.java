package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.LeaveType;

@Repository
public class LeaveTypeDaoImpl implements LeaveTypeDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addLeaveType(LeaveType lt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(lt);
		logger.info("Leave type saved successfully, Person Details=" + lt);

	}

	@Override
	public void updateLeaveType(LeaveType lt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(lt);
		logger.info("Leave type saved successfully, Person Details=" + lt);

	}

	@Override
	public List<LeaveType> listLeaveTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LeaveType> leaveTypes = session.createQuery("from LeaveType")
				.list();
		for (LeaveType len : leaveTypes) {
			logger.info("LeaveType List::" + len);
		}
		return leaveTypes;
	}

	@Override
	public LeaveType getLeaveTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLeaveType(int id) {
		// TODO Auto-generated method stub

	}

}
