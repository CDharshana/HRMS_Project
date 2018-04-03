package com.intervest.hrms.service;

import java.util.List;

import com.intervest.hrms.model.LeaveEntitlement;

public interface LeaveEntitlementService {
	public void addLeaveEntitlement(LeaveEntitlement len);

	public void updateLeaveEntitlement(LeaveEntitlement len);

	public List<LeaveEntitlement> listLeaveEntitlements();

	public LeaveEntitlement getLeaveEntitlementById(int id);

	public void removeLeaveEntitlement(int id);
}
