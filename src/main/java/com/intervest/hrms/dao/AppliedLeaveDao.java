package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.AppliedLeave;

public interface AppliedLeaveDao {
	public void addLeave(AppliedLeave al);

	public void updateLeave(AppliedLeave al);

	public List<AppliedLeave> listAppliedLeaves();

	public AppliedLeave getAppliedLeaveById(int id);

	public void removeAppliedLeave(int id);

	public List<AppliedLeave> getPendingLeavesForSupervisor(int empID);

	public List<String> getLeaveBalance(int empID);
	
	public List<String> getLeaveReport(int empID, String dateFrom, String dateTo);

}
