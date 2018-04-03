package com.intervest.hrms.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(emp);

	}

	@Override
	public void updateEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(emp);

	}

	@Override
	public List<Employee> listEmployees() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("from Employee").list();
		return employees;

	}

	@Override
	public Employee getEmployeeByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if(emp!=null){
			Hibernate.initialize(emp.getAppliedLeaves());
		}
		return emp;
	}

	@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if (null != emp) {
			session.delete(emp);
		}

	}

}
