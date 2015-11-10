package tests.AServices;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.InventoryManager;
import entities.Materials;
import entities.Reward;
import services.interfaces.EmployeeServicesRemote;
import services.interfaces.MaterialsServicesRemote;
import services.interfaces.RewardServicesRemote;
public class TestServiceOne {
	

	public static void main(String[] args) throws NamingException {
		
		Context context = new InitialContext();
		String jndiName = "/erp-bank-ejb/EmployeeServices!services.interfaces.EmployeeServicesRemote";

	
		EmployeeServicesRemote proxy = (EmployeeServicesRemote) context.lookup(jndiName);
		InventoryManager e = new InventoryManager();
		e.setEmail("Moez@gmail.com");
		e.setFirstName("Moez");
		
		e.setPassword("Moez");
		
		
		proxy.addEmployee(e);
		//System.out.println(proxy.identifIM("Moez@gmail.com", "Moez"));
}
}