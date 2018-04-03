package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.AppliedLeaveDao;
import com.intervest.hrms.model.AppliedLeave;

@Service
public class AppliedLeaveServiceImpl implements AppliedLeaveService {
	private AppliedLeaveDao appliedLeaveDao;

	public AppliedLeaveDao getAppliedLeaveDao() {
		return appliedLeaveDao;
	}

	public void setAppliedLeaveDao(AppliedLeaveDao appliedLeaveDao) {
		this.appliedLeaveDao = appliedLeaveDao;
	}

	@Override
	@Transactional
	public void addLeave(AppliedLeave al) {
		this.appliedLeaveDao.addLeave(al);

	}

	@Override
	@Transactional
	public void updateLeave(AppliedLeave al) {
		this.appliedLeaveDao.updateLeave(al);

	}

	@Override
	@Transactional
	public List<AppliedLeave> listAppliedLeaves() {
		return this.appliedLeaveDao.listAppliedLeaves();
	}

	@Override
	@Transactional
	public AppliedLeave getAppliedLeaveById(int id) {
		return this.appliedLeaveDao.getAppliedLeaveById(id);
	}

	@Override
	@Transactional
	public void removeAppliedLeave(int id) {
		this.appliedLeaveDao.removeAppliedLeave(id);

	}

	@Override
	@Transactional
	public List<AppliedLeave> getPendingLeavesForSupervisor(int empID) {
		return this.appliedLeaveDao.getPendingLeavesForSupervisor(empID);
	}

	@Override
	@Transactional
	public List<String> getLeaveBalance(int empID) {
		return this.appliedLeaveDao.getLeaveBalance(empID);
	}

	@Override
	@Transactional
	public List<String> getLeaveReport(int empID, String dateFrom, String dateTo) {
		return this.appliedLeaveDao.getLeaveReport(empID, dateFrom, dateTo);
	}
	
	

}
