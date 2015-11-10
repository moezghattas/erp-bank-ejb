package delegator;

import locator.ServiceLocator;
import services.interfaces.CashierServicesRemote;
import services.interfaces.EmployeeServicesRemote;
import entities.Cashier;

public class CashierDelegate {
private static String jndiName="erp-bank-ejb/CashierServices!services.interfaces.CashierServicesRemote";
	

	public static CashierServicesRemote getInstance() {

		return (CashierServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static void ajoutercaissier(Cashier cashier)
	{
		getInstance().addCashier(cashier);
	}
	
}
