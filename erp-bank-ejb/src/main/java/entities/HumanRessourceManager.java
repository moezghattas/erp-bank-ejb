package entities;

import entities.Employee;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HumanRessourceManager
 *
 */
@Entity
@Table(name="T_HumanRessourceManager")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class HumanRessourceManager extends Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<TrainingSession> trainingsession;
	private List<CandidaciesDemands> candidaciesdemands;
	private List<Reward> rewards;

	

	public HumanRessourceManager() {
		super();
	}


	@OneToMany(mappedBy="humanressourcemanager")
	public List<TrainingSession> getTrainingsession() {
		return trainingsession;
	}



	public void setTrainingsession(List<TrainingSession> trainingsession) {
		this.trainingsession = trainingsession;
	}


	@OneToMany(mappedBy="humanressourcemanager")
	public List<CandidaciesDemands> getCandidaciesdemands() {
		return candidaciesdemands;
	}



	public void setCandidaciesdemands(List<CandidaciesDemands> candidaciesdemands) {
		this.candidaciesdemands = candidaciesdemands;
	}


	@OneToMany(mappedBy="humanressourcemanager")
	public List<Reward> getRewards() {
		return rewards;
	}



	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
	


}
