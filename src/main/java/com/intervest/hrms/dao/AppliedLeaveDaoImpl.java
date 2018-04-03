package com.intervest.hrms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.AppliedLeave;
import com.intervest.hrms.model.LeaveBalance;

@Repository
public class AppliedLeaveDaoImpl implements AppliedLeaveDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addLeave(AppliedLeave al) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(al);
		logger.info("Leave saved successfully, Leave Details=" + al);

	}

	@Override
	public void updateLeave(AppliedLeave al) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(al);
		logger.info("Leave updated successfully, Leave Details=" + al);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppliedLeave> listAppliedLeaves() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AppliedLeave> leaveList = session.createQuery("from AppliedLeave")
				.list();
		return leaveList;
	}

	@Override
	public AppliedLeave getAppliedLeaveById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AppliedLeave al = (AppliedLeave) session.load(AppliedLeave.class,
				new Integer(id));
		logger.info("Leave loaded successfully, Leave details=" + al);
		return al;
	}

	@Override
	public void removeAppliedLeave(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AppliedLeave al = (AppliedLeave) session.load(AppliedLeave.class,
				new Integer(id));
		if (null != al) {
			session.delete(al);
		}
		logger.info("Leave deleted successfully, Leave details=" + al);

	}

	@Override
	public List<AppliedLeave> getPendingLeavesForSupervisor(int empID) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AppliedLeave.class, "ap");
		criteria.createAlias("ap.employee", "emp");
		criteria.createAlias("ap.leaveStatus", "ls");
		criteria.createAlias("emp.supervisor", "sup");
		criteria.add(Restrictions.eq("sup.id", empID));
		criteria.add(Restrictions.eq("ls.id", 1));

		List<AppliedLeave> appliedLeaves = criteria.list();
		return appliedLeaves;
	}

	@Override
	public List<String> getLeaveBalance(int empID) {
		Session session = this.sessionFactory.getCurrentSession();
		List<LeaveBalance> lb = new ArrayList<LeaveBalance>();
		Query query = session.createSQLQuery("CALL leave_balance(:empID)")
				.addScalar("leaveTypeName", new StringType())
				.addScalar("allocation", new StringType())
				.addScalar("utilization", new StringType())
				.addScalar("pending", new StringType())
				.addScalar("balance", new StringType())
				.setParameter("empID", empID);
		List<String> objcts = query.list();

		return objcts;
	}

	@Override
	public List<String> getLeaveReport(int empID, String dateFrom, String dateTo) {
		Session session = this.sessionFactory.getCurrentSession();
		List<LeaveBalance> lb = new ArrayList<LeaveBalance>();
		Query query = session
				.createSQLQuery("CALL leave_report(:empID,:dateFrom, :dateTo)")
				.addScalar("leaveTypeName", new StringType())
				.addScalar("allocation", new StringType())
				.addScalar("utilization", new StringType())
				.addScalar("pending", new StringType())
				.addScalar("balance", new StringType())
				.setParameter("empID", empID).setParameter("empID", empID)
				.setParameter("dateFrom", dateFrom)
				.setParameter("dateTo", dateTo);
		List<String> objcts = query.list();

		return objcts;
	}
}
