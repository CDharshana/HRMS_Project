package com.intervest.hrms.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leave_types")
public class LeaveType {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "leave_type_name")
	private String leaveTypeName;
	private String description;

	@OneToMany(mappedBy = "leaveType")
	private Set<AppliedLeave> appliedLeaves;

	@OneToMany(mappedBy = "leaveType")
	private Set<EntitlementDetail> entitlements;

	public Set<AppliedLeave> getAppliedLeaves() {
		return appliedLeaves;
	}

	public void setAppliedLeaves(Set<AppliedLeave> appliedLeaves) {
		this.appliedLeaves = appliedLeaves;
	}

	public Set<EntitlementDetail> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(Set<EntitlementDetail> entitlements) {
		this.entitlements = entitlements;
	}

	private int status = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
