package delegator;

import locator.ServiceLocator;
import services.interfaces.EmployeeServicesRemote;
import services.interfaces.HumanRessourceManagerServicesRemote;
import entities.Employee;
import entities.HumanRessourceManager;

public class humanressourceDelegate {
private static String jndiName="erp-bank-ejb/HumanRessourceManagerServices!services.interfaces.HumanRessourceManagerServicesRemote";
	

	public static HumanRessourceManagerServicesRemote getInstance() {

		return (HumanRessourceManagerServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static void ajouterEmploye(HumanRessourceManager a)
	{
		getInstance().addhumanressource_manager(a);
	}
	
}
