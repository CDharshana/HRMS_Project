package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.LeaveType;

public interface LeaveTypeDao {
	public void addLeaveType(LeaveType lt);

	public void updateLeaveType(LeaveType lt);

	public List<LeaveType> listLeaveTypes();

	public LeaveType getLeaveTypeById(int id);

	public void removeLeaveType(int id);
}
