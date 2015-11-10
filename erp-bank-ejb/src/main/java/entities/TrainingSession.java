package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrainingSession
 *
 */
@Entity
@Table(name="T_TrainingSession")

public class TrainingSession implements Serializable {

	
	private Integer IdTrainingSession;
	private String SessionName;
	private String TrainingDate;
	private String Goal;
	private String CoachName;
	private static final long serialVersionUID = 1L;
	private HumanRessourceManager humanressourcemanager;


	public TrainingSession() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getIdTrainingSession() {
		return this.IdTrainingSession;
	}

	public String getSessionName() {
		return SessionName;
	}
	public void setSessionName(String sessionName) {
		SessionName = sessionName;
	}
	public void setIdTrainingSession(Integer IdTrainingSession) {
		this.IdTrainingSession = IdTrainingSession;
	}   

	
	public String getTrainingDate() {
		return TrainingDate;
	}
	public void setTrainingDate(String trainingDate) {
		TrainingDate = trainingDate;
	}
	public String getGoal() {
		return this.Goal;
	}

	public void setGoal(String Goal) {
		this.Goal = Goal;
	}   
	public String getCoachName() {
		return this.CoachName;
	}

	public void setCoachName(String CoachName) {
		this.CoachName = CoachName;
	}
	@ManyToOne
	public HumanRessourceManager getHumanressourcemanager() {
		return humanressourcemanager;
	}
	public void setHumanressourcemanager(HumanRessourceManager humanressourcemanager) {
		this.humanressourcemanager = humanressourcemanager;
	}
	
   
}
