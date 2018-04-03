package com.intervest.hrms.dao;

import java.util.List;

import com.intervest.hrms.model.TrainingProgram;

public interface TrainingProgramDao {
	public void addTrainingProgram(TrainingProgram tp);

	public void updateTrainingProgram(TrainingProgram tp);

	public List<TrainingProgram> listTrainingPrograms();

	public TrainingProgram getTrainingProgramById(int id);

	public void removeTrainingProgram(int id);

	public List<TrainingProgram> listTrainingProgramsForUser(int userID);

}
