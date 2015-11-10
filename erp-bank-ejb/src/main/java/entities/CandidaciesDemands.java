package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CandidaciesDemands
 *
 */
@Entity
@Table(name="T_CandidaciesDemands")

public class CandidaciesDemands implements Serializable {

	
	private Integer IdDemand;
	private String Lastname;
	private String Firstname;
	private String Email;
	private String Motivation;
	private String Phone;
	private String CIN;
	private String birthDate;
	private String adress;
	private String sexe;
	private String civilState;
	private int kidsNumber;
	private String Poste;
	private String Password;
	private static final long serialVersionUID = 1L;
	private HumanRessourceManager humanressourcemanager;

	public CandidaciesDemands() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getIdDemand() {
		return this.IdDemand;
	}

	public void setIdDemand(Integer IdDemand) {
		this.IdDemand = IdDemand;
	}   
	public String getLastname() {
		return this.Lastname;
	}

	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}   
	public String getFirstname() {
		return this.Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getMotivation() {
		return this.Motivation;
	}

	public void setMotivation(String Motivation) {
		this.Motivation = Motivation;
	}   
	public String getPhone() {
		return this.Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	@ManyToOne

	public HumanRessourceManager getHumanressourcemanager() {
		return humanressourcemanager;
	}
	public void setHumanressourcemanager(HumanRessourceManager humanressourcemanager) {
		this.humanressourcemanager = humanressourcemanager;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCivilState() {
		return civilState;
	}
	public void setCivilState(String civilState) {
		this.civilState = civilState;
	}
	public int getKidsNumber() {
		return kidsNumber;
	}
	public void setKidsNumber(int kidsNumber) {
		this.kidsNumber = kidsNumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPoste() {
		return Poste;
	}
	public void setPoste(String poste) {
		Poste = poste;
	}
	
   
	
}
