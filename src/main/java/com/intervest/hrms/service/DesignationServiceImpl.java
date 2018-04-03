package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.DesignationDao;
import com.intervest.hrms.model.Designation;

@Service
public class DesignationServiceImpl implements DesignationService {

	private DesignationDao designationDao;

	public DesignationDao getDesignationDao() {
		return designationDao;
	}

	public void setDesignationDao(DesignationDao designationDao) {
		this.designationDao = designationDao;
	}

	@Override
	@Transactional
	public List<Designation> listDesignations() {
		return this.designationDao.listDesignations();

	}

}
