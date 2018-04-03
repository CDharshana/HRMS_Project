package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.Holiday;

@Repository
public class HolidayDaoImpl implements HolidayDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addHoliday(Holiday holiday) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(holiday);

	}

	@Override
	public void updateHoliday(Holiday holiday) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(holiday);

	}

	@Override
	public List<Holiday> listHolidays() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Holiday> holidayList = session.createQuery("from Holiday").list();

		return holidayList;
	}

	@Override
	public Holiday getHolidayById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeHoliday(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Holiday getHolidayByDate(String date) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Holiday where date = :date");
		query.setParameter("date", date);
		List<Holiday> holidayList = query.list();
		return holidayList.get(0);
	}

}
