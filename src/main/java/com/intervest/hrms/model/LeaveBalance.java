package com.intervest.hrms.model;


public class LeaveBalance {
	private String leaveTypeName;
	private String allocation;
	private String utilization;
	private String pending;
	private String balance;

	public LeaveBalance(String leaveTypeName, String allocation,
			String utilization, String pending, String balance) {
		this.leaveTypeName = leaveTypeName;
		this.allocation = allocation;
		this.utilization = utilization;
		this.pending = pending;
		this.balance = balance;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getAllocation() {
		return allocation;
	}

	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}

	public String getUtilization() {
		return utilization;
	}

	public void setUtilization(String utilization) {
		this.utilization = utilization;
	}

	public String getPending() {
		return pending;
	}

	public void setPending(String pending) {
		this.pending = pending;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}


}
