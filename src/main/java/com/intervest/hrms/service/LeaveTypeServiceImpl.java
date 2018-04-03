package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.LeaveTypeDao;
import com.intervest.hrms.model.LeaveType;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
	private LeaveTypeDao leaveTypeDao;

	public LeaveTypeDao getLeaveTypeDao() {
		return leaveTypeDao;
	}

	public void setLeaveTypeDao(LeaveTypeDao leaveTypeDao) {
		this.leaveTypeDao = leaveTypeDao;
	}

	@Override
	@Transactional
	public void addLeaveType(LeaveType leaveType) {
		this.leaveTypeDao.addLeaveType(leaveType);

	}

	@Override
	@Transactional
	public void updateLeaveType(LeaveType leaveType) {
		this.leaveTypeDao.updateLeaveType(leaveType);

	}

	@Override
	@Transactional
	public List<LeaveType> listLeaveTypes() {
		return this.leaveTypeDao.listLeaveTypes();
	}

	@Override
	@Transactional
	public LeaveType getLeaveTypeByID(int id) {
		return this.leaveTypeDao.getLeaveTypeById(id);

	}

	@Override
	@Transactional
	public void removeLeaveType(int id) {
		this.leaveTypeDao.removeLeaveType(id);

	}

}
