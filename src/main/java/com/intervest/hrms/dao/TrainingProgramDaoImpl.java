package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.TrainingProgram;

@Repository
public class TrainingProgramDaoImpl implements TrainingProgramDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addTrainingProgram(TrainingProgram tp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tp);

	}

	@Override
	public void updateTrainingProgram(TrainingProgram tp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tp);
	}

	@Override
	public List<TrainingProgram> listTrainingPrograms() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TrainingProgram> trainingProgram = session.createQuery(
				"from TrainingProgram").list();
		return trainingProgram;
	}

	@Override
	public List<TrainingProgram> listTrainingProgramsForUser(int userID) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TrainingProgram.class, "tp");
		criteria.createAlias("tp.trainingEmployees", "trEmp");
		criteria.createAlias("trEmp.employee", "emp");
		criteria.createAlias("emp.user", "user");
		criteria.add(Restrictions.eq("user.userID", userID));
		List<TrainingProgram> trainingPrograms = criteria.list();
		return trainingPrograms;
	}

	@Override
	public TrainingProgram getTrainingProgramById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeTrainingProgram(int id) {
		// TODO Auto-generated method stub

	}

}
