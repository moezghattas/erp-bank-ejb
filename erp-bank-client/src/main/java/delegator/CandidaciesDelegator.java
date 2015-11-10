package delegator;

import java.util.List;

import entities.CandidaciesDemands;
import entities.Employee;
import locator.ServiceLocator;
import services.interfaces.CandidaciesDemandsServicesRemote;
import services.interfaces.EmployeeServicesRemote;

public class CandidaciesDelegator {

	private static String jndiName="erp-bank-ejb/CandidaciesDemandsServices!services.interfaces.CandidaciesDemandsServicesRemote";
	

	public static CandidaciesDemandsServicesRemote getInstance() {

		return (CandidaciesDemandsServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static List<CandidaciesDemands> findallCandidacies()
	{
		return getInstance().findAllCandidaciesDemands();
		
	}
	public static void decline(CandidaciesDemands cand) {
		getInstance().deletecandidaciesdemands(cand);
	}
	
	
}
