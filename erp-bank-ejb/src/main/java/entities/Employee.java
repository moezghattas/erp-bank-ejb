package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	
	private Integer IdEmployee;
	private String CIN;
	private String FirstName;
	private String LastName;
	private String Email;
	private String birthDate;
	private String adress;
	private String phoneNumber;
	private String sexe;
	private String civilState;
	private int kidsNumber;
	private String Password;
	private Payslip payslip;
	private Boolean IsDeleted;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getIdEmployee() {
		return this.IdEmployee;
	}

	public void setIdEmployee(Integer IdEmployee) {
		this.IdEmployee = IdEmployee;
	}   
	public String getFirstName() {
		return this.FirstName;
	}
	@ManyToOne
	public Payslip getPayslip() {
		return payslip;
	}
	public void setPayslip(Payslip payslip) {
		this.payslip = payslip;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public Boolean getIsDeleted() {
		return this.IsDeleted;
	}

	public void setIsDeleted(Boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	
	
   
}
