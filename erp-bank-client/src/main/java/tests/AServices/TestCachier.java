package tests.AServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.CashierServicesRemote;

import entities.Cashier;

public class TestCachier {

	public static void main(String[] args)throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		String jndiName = "/erp-bank-ejb/CashierServices!services.interfaces.CashierServicesRemote";
		CashierServicesRemote proxy = (CashierServicesRemote) context.lookup(jndiName);
		
		Cashier cashier = new Cashier();
		cashier.setAdress("adress");
cashier.setBirthDate("11/12/2007");
cashier.setCIN("123456789");
cashier.setCivilState("married");
cashier.setEmail("email@email");
cashier.setFirstName("first");
cashier.setLastName("LastName");
cashier.setKidsNumber(3);
cashier.setPassword("123456");
cashier.setSexe("homme");
cashier.setIsDeleted(false);
//proxy.addCashier(cashier);
//proxy.updateCashier(cashier);
proxy.deleteCashierById(2);
	}

}
