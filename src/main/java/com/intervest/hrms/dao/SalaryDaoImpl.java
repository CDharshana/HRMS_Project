package com.intervest.hrms.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.intervest.hrms.model.Employee;
import com.intervest.hrms.model.VariableDeduction;
import com.intervest.hrms.model.VariablePay;

@Repository
public class SalaryDaoImpl implements SalaryDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LeaveTypeDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void updateSalary(int id, String new_Salary) {

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "UPDATE employees SET basic_salary=:salary WHERE id=:empId";
		session.createSQLQuery(sql)
				.setParameter("salary", new_Salary)
				.setParameter("empId", id)
				.executeUpdate();

	}
	
	@Override
	public List<VariablePay> listVariablePay() {

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM variable_pay";
		List<VariablePay> variablepays = session.createSQLQuery(sql)
				.addScalar("id", new IntegerType())
				.addScalar("description", new StringType())
				.addScalar("amount", new DoubleType())
				.addScalar("mode", new StringType())
				.setResultTransformer(Transformers.aliasToBean(VariablePay.class)).list();
		return variablepays;

	}
	
	@Override
	public void addVariablePay(VariablePay variablepay) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(variablepay);

	}
	
	@Override
	public VariablePay getVariablePayID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		VariablePay variablePay = (VariablePay) session.load(VariablePay.class, new Integer(id));

		return variablePay;
	}
	
	@Override
	public void updateVariablePay(VariablePay variablepay) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(variablepay);
	}
	
	@Override
	public void deleteVariablePay(VariablePay variablepay) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(variablepay);
	}
	
	@Override
	public List<VariableDeduction> listVariableDeduction() {

		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM variable_deduction";
		List<VariableDeduction> variabledeductions = session.createSQLQuery(sql)
				.addScalar("id", new IntegerType())
				.addScalar("description", new StringType())
				.addScalar("amount", new DoubleType())
				.addScalar("mode", new StringType())
				.setResultTransformer(Transformers.aliasToBean(VariableDeduction.class)).list();
		return variabledeductions;

	}
	
	@Override
	public void addVariableDeduction(VariableDeduction variableDeduction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(variableDeduction);

	}

	@Override
	public VariableDeduction getVariableDeductionID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		VariableDeduction variableDeduction = (VariableDeduction) session.load(VariableDeduction.class, new Integer(id));

		return variableDeduction;
	}
	
	@Override
	public void updateVariableDeduction(VariableDeduction variableDeduction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(variableDeduction);
	}
	
	@Override
	public void deleteVariableDeduction(VariableDeduction variableDeduction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(variableDeduction);
	}
	
	@Override
	public void addProcessPay(String empId, String employee, String payment, String endingDate, String payId) {
		Session session = this.sessionFactory.getCurrentSession();
		if (employee.equals("allemployees")) {
			List<Employee> employees = session.createQuery("from Employee").list();
			String sql = "INSERT INTO emp_pay_deduct (emp_id, var_id, payment, ending_date) VALUES (:empId, :varId, :payment, :ending_date)";
			for (Employee emp : employees) {	
				session.createSQLQuery(sql)
				.setParameter("empId", emp.getId())
				.setParameter("varId", payId)
				.setParameter("payment", payment)
				.setParameter("ending_date", endingDate)
				.executeUpdate();
			}
		}
		else {
			String sql = "INSERT INTO emp_pay_deduct (emp_id, var_id, payment, ending_date) VALUES (:empId, :varId, :payment, :ending_date)";
			session.createSQLQuery(sql)
			.setParameter("empId", empId)
			.setParameter("varId", payId)
			.setParameter("payment", payment)
			.setParameter("ending_date", endingDate)
			.executeUpdate();
		}
		
	}
	
	@Override
	public void addProcessDeduction(String empId, String employee, String payment, String endingDate, String deductionId) {
		Session session = this.sessionFactory.getCurrentSession();
		if (employee.equals("allemployees")) {
			List<Employee> employees = session.createQuery("from Employee").list();
			String sql = "INSERT INTO emp_pay_deduct (emp_id, ded_id, payment, ending_date) VALUES (:empId, :dedId, :payment, :ending_date)";
			for (Employee emp : employees) {	
				session.createSQLQuery(sql)
				.setParameter("empId", emp.getId())
				.setParameter("dedId", deductionId)
				.setParameter("payment", payment)
				.setParameter("ending_date", endingDate)
				.executeUpdate();
			}
		}
		else {
			String sql = "INSERT INTO emp_pay_deduct (emp_id, ded_id, payment, ending_date) VALUES (:empId, :dedId, :payment, :ending_date)";
			session.createSQLQuery(sql)
			.setParameter("empId", empId)
			.setParameter("dedId", deductionId)
			.setParameter("payment", payment)
			.setParameter("ending_date", endingDate)
			.executeUpdate();
		}
		
	}
	
	@Override
	public List salaryDetails(String empId) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql1 = "SELECT * FROM variable_pay WHERE id IN (SELECT var_id FROM emp_pay_deduct WHERE emp_id = :empId)";
		List<VariablePay> variablePay = session.createSQLQuery(sql1)
				.addScalar("id", new IntegerType())
				.addScalar("description", new StringType())
				.addScalar("amount", new DoubleType())
				.addScalar("mode", new StringType())
				.setParameter("empId", empId)
				.setResultTransformer(Transformers.aliasToBean(VariablePay.class)).list();
		
		String sql2 = "SELECT * FROM variable_deduction WHERE id IN (SELECT ded_id FROM emp_pay_deduct WHERE emp_id = :empId)";
		List<VariableDeduction> variableDeduction = session.createSQLQuery(sql2)
				.addScalar("id", new IntegerType())
				.addScalar("description", new StringType())
				.addScalar("amount", new DoubleType())
				.addScalar("mode", new StringType())
				.setParameter("empId", empId)
				.setResultTransformer(Transformers.aliasToBean(VariableDeduction.class)).list();
		List salaryDetails = new LinkedList();
		salaryDetails.add(variablePay);
		salaryDetails.add(variableDeduction);
		return salaryDetails;

	}
	
	

	
	


}
