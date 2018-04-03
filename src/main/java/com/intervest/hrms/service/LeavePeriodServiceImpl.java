package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.LeavePeriodDao;
import com.intervest.hrms.model.LeavePeriod;

@Service
public class LeavePeriodServiceImpl implements LeavePeriodService {

	private LeavePeriodDao leavePeriodDao;

	public LeavePeriodDao getLeavePeriodDao() {
		return leavePeriodDao;
	}

	public void setLeavePeriodDao(LeavePeriodDao leavePeriodDao) {
		this.leavePeriodDao = leavePeriodDao;
	}

	@Override
	@Transactional
	public void addLeavePeriod(LeavePeriod lp) {
		this.leavePeriodDao.addLeavePeriod(lp);

	}

	@Override
	@Transactional
	public void updateLeavePeriod(LeavePeriod lp) {
		this.leavePeriodDao.updateLeavePeriod(lp);

	}

	@Override
	@Transactional
	public List<LeavePeriod> listLeavePeriods() {
		return this.leavePeriodDao.listLeavePeriods();
	}

	@Override
	@Transactional
	public LeavePeriod getLeavePeriodById(int id) {
		return this.leavePeriodDao.getLeavePeriodById(id);
	}

	@Override
	@Transactional
	public void removeLeavePeriod(int id) {
		this.leavePeriodDao.removeLeavePeriod(id);

	}

}
