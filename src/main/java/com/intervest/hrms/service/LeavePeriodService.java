package com.intervest.hrms.service;

import java.util.List;

import com.intervest.hrms.model.LeavePeriod;

public interface LeavePeriodService {
	public void addLeavePeriod(LeavePeriod lp);

	public void updateLeavePeriod(LeavePeriod lp);

	public List<LeavePeriod> listLeavePeriods();

	public LeavePeriod getLeavePeriodById(int id);

	public void removeLeavePeriod(int id);
}
