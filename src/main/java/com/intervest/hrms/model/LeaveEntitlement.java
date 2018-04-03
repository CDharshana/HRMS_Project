package com.intervest.hrms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leave_entitlements")
public class LeaveEntitlement {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "date_from")
	private String fromDate;
	@Column(name = "date_to")
	private String toDate;
	private int status = 1;

	@OneToMany(mappedBy = "entitlement", cascade = CascadeType.ALL)
	private List<EntitlementDetail> entitlements;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<EntitlementDetail> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(List<EntitlementDetail> entitlements) {
		this.entitlements = entitlements;
	}

}
