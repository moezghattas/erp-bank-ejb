package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payslip
 *
 */
@Entity
@Table(name="T_Payslip")

public class Payslip implements Serializable {

	
	private Integer idPayslip;
	private String paye;
	private List<Employee> employees;
	private String taxe;
	private static final long serialVersionUID = 1L;

	public Payslip() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getIdPayslip() {
		return this.idPayslip;
	}

	public void setIdPayslip(Integer idPayslip) {
		this.idPayslip = idPayslip;
	}   
	public String getPaye() {
		return this.paye;
	}
	@OneToMany(mappedBy="payslip")
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public void setPaye(String paye) {
		this.paye = paye;
	}   
	public String getTaxe() {
		return this.taxe;
	}

	public void setTaxe(String taxe) {
		this.taxe = taxe;
	}
   
}
