package entities;

import entities.BankAccount;
import java.io.Serializable;
import java.lang.Double;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SavingAccount
 *
 */
@Entity

public class SavingAccount extends BankAccount implements Serializable {

	
	private Double rate;
	private Double intrestAccumulated;
	private static final long serialVersionUID = 1L;

	public SavingAccount() {
		super();
	}   
	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}   
	public Double getIntrestAccumulated() {
		return this.intrestAccumulated;
	}

	public void setIntrestAccumulated(Double intrestAccumulated) {
		this.intrestAccumulated = intrestAccumulated;
	}
   
}
