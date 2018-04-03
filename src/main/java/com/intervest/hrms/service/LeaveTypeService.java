package com.intervest.hrms.service;

import java.util.List;

import com.intervest.hrms.model.LeaveType;

public interface LeaveTypeService {

	public void addLeaveType(LeaveType lt);

	public void updateLeaveType(LeaveType lt);

	public List<LeaveType> listLeaveTypes();

	public LeaveType getLeaveTypeByID(int id);

	public void removeLeaveType(int id);

}
