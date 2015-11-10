package delegator;

import java.util.List;

import entities.Employee;
import entities.TrainingSession;
import locator.ServiceLocator;
import services.interfaces.TraningSessionServicesRemote;

public class TrainingSessionDelegator {

	
	
	
private static String jndiName="erp-bank-ejb/TraningSessionServices!services.interfaces.TraningSessionServicesRemote";
	

	public static TraningSessionServicesRemote getInstance() {

		return (TraningSessionServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}
	public static List<TrainingSession> findAllTrainingsession()
	{
		return getInstance().findAllTrainingSession();
		
	}
	public static void ajoutersession(TrainingSession session)
	{
		getInstance().addtrainingsession(session);
	}
	public static void deletesession(TrainingSession session)
	{
		getInstance().deletetrainingsession(session);
	}
	public static void updatesession(TrainingSession session)
	{
		getInstance().updatetrainingsession(session);
	}
}
