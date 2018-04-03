package com.intervest.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intervest.hrms.dao.TrainingProgramDao;
import com.intervest.hrms.model.TrainingProgram;

@Service
public class TrainingProgramServiceImpl implements TrainingProgramService {
	private TrainingProgramDao trainingProgramDao;

	public TrainingProgramDao getTrainingProgramDao() {
		return trainingProgramDao;
	}

	public void setTrainingProgramDao(TrainingProgramDao trainingProgramDao) {
		this.trainingProgramDao = trainingProgramDao;
	}

	@Override
	@Transactional
	public void addTrainingProgram(TrainingProgram tp) {
		this.trainingProgramDao.addTrainingProgram(tp);

	}

	@Override
	@Transactional
	public void updateTrainingProgram(TrainingProgram tp) {
		this.trainingProgramDao.updateTrainingProgram(tp);

	}

	@Override
	@Transactional
	public List<TrainingProgram> listTrainingPrograms() {
		return this.trainingProgramDao.listTrainingPrograms();
	}

	@Override
	@Transactional
	public TrainingProgram getTrainingProgramById(int id) {
		return this.trainingProgramDao.getTrainingProgramById(id);
	}

	@Override
	@Transactional
	public void removeTrainingProgram(int id) {
		this.trainingProgramDao.removeTrainingProgram(id);

	}

	@Override
	@Transactional
	public List<TrainingProgram> listTrainingProgramsForUser(int userID) {
		return this.trainingProgramDao.listTrainingProgramsForUser(userID);

	}

}
