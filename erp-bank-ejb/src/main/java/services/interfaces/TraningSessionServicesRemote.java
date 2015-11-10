package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.TrainingSession;
import entities.TrainingSession;

@Remote
public interface TraningSessionServicesRemote {
Boolean addtrainingsession(TrainingSession trainingsession);
	
	Boolean deletetrainingsessionById(Integer id);

	TrainingSession findtrainingsessionById(Integer id);

	Boolean updatetrainingsession(TrainingSession trainingsession);

	Boolean deletetrainingsession(TrainingSession trainingsession);

	List<TrainingSession> findAllTrainingSession();

}
