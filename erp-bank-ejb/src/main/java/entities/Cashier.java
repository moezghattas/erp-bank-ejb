package entities;

import entities.Employee;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cashier
 *
 */
@Entity

public class Cashier extends Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Cashier() {
		super();
	}
   
}
