package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.HolidayDao;
import com.intervest.hrms.model.Holiday;

@Service
public class HolidayServiceImpl implements HolidayService {
	private HolidayDao holidayDao;

	public HolidayDao getHolidayDao() {
		return holidayDao;
	}

	public void setHolidayDao(HolidayDao holidayDao) {
		this.holidayDao = holidayDao;
	}

	@Override
	@Transactional
	public void addHoliday(Holiday holiday) {
		this.holidayDao.addHoliday(holiday);

	}

	@Override
	@Transactional
	public void updateHoliday(Holiday holiday) {
		this.holidayDao.updateHoliday(holiday);

	}

	@Override
	@Transactional
	public List<Holiday> listHolidays() {

		return this.holidayDao.listHolidays();
	}

	@Override
	@Transactional
	public Holiday getHolidayById(int id) {
		return this.holidayDao.getHolidayById(id);
	}

	@Override
	@Transactional
	public void removeHoliday(int id) {
		this.holidayDao.removeHoliday(id);

	}

	@Override
	@Transactional
	public Holiday getHolidayByDate(String date) {
		this.holidayDao.getHolidayByDate(date);
		return null;
	}

}
