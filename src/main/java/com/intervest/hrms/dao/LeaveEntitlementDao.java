package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.LeaveEntitlement;

public interface LeaveEntitlementDao {
	public void addLeaveEntitlement(LeaveEntitlement len);

	public void updateLeaveEntitlement(LeaveEntitlement len);

	public List<LeaveEntitlement> listLeaveEntitlements();

	public LeaveEntitlement getLeaveEntitlementById(int id);

	public void removeLeaveEntitlement(int id);
}
