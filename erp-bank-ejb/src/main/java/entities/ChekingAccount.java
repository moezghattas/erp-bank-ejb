package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChekingAccount
 *
 */
@Entity

public class ChekingAccount extends BankAccount implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public ChekingAccount() {
		super();
	}
   
}
