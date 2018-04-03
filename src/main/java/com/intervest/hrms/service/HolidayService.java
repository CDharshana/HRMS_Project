package com.intervest.hrms.service;

import java.util.List;

import com.intervest.hrms.model.Holiday;

public interface HolidayService {
	public void addHoliday(Holiday holiday);

	public void updateHoliday(Holiday holiday);

	public List<Holiday> listHolidays();

	public Holiday getHolidayById(int id);

	public void removeHoliday(int id);
	
	public Holiday getHolidayByDate(String date);

}
