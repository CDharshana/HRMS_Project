package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.LeaveEntitlementDao;
import com.intervest.hrms.model.LeaveEntitlement;

@Service
public class LeaveEntitlementServiceImpl implements LeaveEntitlementService {
	private LeaveEntitlementDao leaveEntitlementDao;

	public LeaveEntitlementDao getLeaveEntitlementDao() {
		return leaveEntitlementDao;
	}

	public void setLeaveEntitlementDao(LeaveEntitlementDao leaveEntitlementDao) {
		this.leaveEntitlementDao = leaveEntitlementDao;
	}

	@Override
	@Transactional
	public void addLeaveEntitlement(LeaveEntitlement len) {
		this.leaveEntitlementDao.addLeaveEntitlement(len);
	}

	@Override
	@Transactional
	public void updateLeaveEntitlement(LeaveEntitlement len) {
		this.leaveEntitlementDao.updateLeaveEntitlement(len);

	}

	@Override
	@Transactional
	public List<LeaveEntitlement> listLeaveEntitlements() {
		return this.leaveEntitlementDao.listLeaveEntitlements();
	}

	@Override
	@Transactional
	public LeaveEntitlement getLeaveEntitlementById(int id) {
		return this.leaveEntitlementDao.getLeaveEntitlementById(id);
	}

	@Override
	@Transactional
	public void removeLeaveEntitlement(int id) {
		this.leaveEntitlementDao.removeLeaveEntitlement(id);

	}

}
