package entities;

import entities.BankAccount;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CertificateOfDeposit
 *
 */
@Entity

public class CertificateOfDeposit extends BankAccount implements Serializable {

	
	private Double rate;
	private Integer PeriodInYears;
	private static final long serialVersionUID = 1L;

	public CertificateOfDeposit() {
		super();
	}   
	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}   
	public Integer getPeriodInYears() {
		return this.PeriodInYears;
	}

	public void setPeriodInYears(Integer PeriodInYears) {
		this.PeriodInYears = PeriodInYears;
	}
   
}
