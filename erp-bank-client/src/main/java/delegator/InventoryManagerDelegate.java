package delegator;

import locator.ServiceLocator;
import services.interfaces.EmployeeServicesRemote;
import services.interfaces.InventoryMangerServicesRemote;
import entities.Employee;
import entities.InventoryManager;

public class InventoryManagerDelegate {
private static String jndiName="erp-bank-ejb/InventoryMangerServices!services.interfaces.InventoryMangerServicesRemote";
	

	public static InventoryMangerServicesRemote getInstance() {

		return (InventoryMangerServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static void ajouterEmploye(InventoryManager employe)
	{
		getInstance().addinventory_manager(employe);
	}
	
}
