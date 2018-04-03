package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.AppliedLeave;
import com.intervest.hrms.model.LeaveEntitlement;

@Repository
public class LeaveEntitlementDaoImpl implements LeaveEntitlementDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addLeaveEntitlement(LeaveEntitlement len) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(len);
		logger.info("Entitlement saved successfully, Entitlement Details="
				+ len);

	}

	@Override
	public void updateLeaveEntitlement(LeaveEntitlement len) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(len);
		logger.info("LeaveEntitlement updated successfully, Entitlement Details="
				+ len);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveEntitlement> listLeaveEntitlements() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LeaveEntitlement> entitlementList = session.createQuery(
				"from LeaveEntitlement").list();
		for (LeaveEntitlement len : entitlementList) {
			logger.info("Entitlement List::" + len);
		}
		return entitlementList;
	}

	@Override
	public LeaveEntitlement getLeaveEntitlementById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LeaveEntitlement len = (LeaveEntitlement) session.load(
				LeaveEntitlement.class, new Integer(id));
		logger.info("LeaveEntitlement loaded successfully, Entitlement details="
				+ len);
		return len;
	}

	@Override
	public void removeLeaveEntitlement(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LeaveEntitlement len = (LeaveEntitlement) session.load(
				AppliedLeave.class, new Integer(id));
		if (null != len) {
			session.delete(len);
		}
		logger.info("LeaveEntitlement deleted successfully, Entitlement details="
				+ len);

	}

}
