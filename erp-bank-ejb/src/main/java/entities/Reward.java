package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reward
 *
 */
@Entity
@Table(name="T_Reward")

public class Reward implements Serializable {

	
	private Integer IdReward;
	private String Libelle;
	private static final long serialVersionUID = 1L;
	private HumanRessourceManager humanressourcemanager;
	

	public Reward() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdReward() {
		return this.IdReward;
	}

	public void setIdReward(Integer IdReward) {
		this.IdReward = IdReward;
	}   
	public String getLibelle() {
		return this.Libelle;
	}

	public void setLibelle(String Libelle) {
		this.Libelle = Libelle;
	}
	@ManyToOne
	public HumanRessourceManager getHumanressourcemanager() {
		return humanressourcemanager;
	}
	public void setHumanressourcemanager(HumanRessourceManager humanressourcemanager) {
		this.humanressourcemanager = humanressourcemanager;
	}
	
   
}
