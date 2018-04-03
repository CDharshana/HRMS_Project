package com.intervest.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

@Entity
///@Proxy(lazy = false)
@Table(name = "applied_leaves")
public class AppliedLeave {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "leave_type")
	private LeaveType leaveType;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	private String fromDate;
	private String toDate;
	@ManyToOne
	@JoinColumn(name = "leave_amount")
	private LeaveAmount leaveAmount;
	@ManyToOne
	@JoinColumn(name = "status")
	private LeaveStatus leaveStatus;

	private String reason;

	@Formula("(DATEDIFF(toDate, fromDate))+1")
	private int numberOfDays;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public LeaveAmount getLeaveAmount() {
		return leaveAmount;
	}

	public void setLeaveAmount(LeaveAmount leaveAmount) {
		this.leaveAmount = leaveAmount;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	/*
	 * public long getNumberOfDays() { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); long numberOfDays = 0; try { Date d1 =
	 * sdf.parse(this.fromDate); Date d2 = sdf.parse(this.toDate); long diff =
	 * d2.getTime() - d1.getTime(); numberOfDays = TimeUnit.DAYS.convert(diff,
	 * TimeUnit.MILLISECONDS); } catch (ParseException e) {
	 * 
	 * e.printStackTrace(); } return numberOfDays; }
	 */

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

}
