package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.TrainingSession;

@Local
public interface TraningSessionServicesLocal {
Boolean addtrainingsession(TrainingSession trainingsession);
	
	Boolean deletetrainingsessionById(Integer id);

	TrainingSession findtrainingsessionById(Integer id);

	Boolean updatetrainingsession(TrainingSession trainingsession);

	Boolean deletetrainingsession(TrainingSession trainingsession);

	List<TrainingSession> findAllTrainingSession();
}
