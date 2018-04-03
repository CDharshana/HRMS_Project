package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.Holiday;

public interface HolidayDao {
	public void addHoliday(Holiday holiday);

	public void updateHoliday(Holiday holiday);

	public List<Holiday> listHolidays();

	public Holiday getHolidayById(int id);

	public void removeHoliday(int id);
	
	public Holiday getHolidayByDate(String date);
}
