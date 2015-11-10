package delegator;

import java.util.List;

import entities.Employee;
import locator.ServiceLocator;
import services.interfaces.EmployeeServicesRemote;


public class GestionEmployeeDelegator {

	private static String jndiName="erp-bank-ejb/EmployeeServices!services.interfaces.EmployeeServicesRemote";
	

	public static EmployeeServicesRemote getInstance() {

		return (EmployeeServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static void ajouterEmploye(Employee employe)
	{
		getInstance().addEmployee(employe);
	}

	public static void supprimerEmploye(Employee employe) {
		getInstance().deleteEmployee(employe);
	}
	
	/*public static boolean findEmployee(String email, String pwd)
	{
		 return getInstance().
		
	}*/
	public static List<Employee> findAllEmployee()
	{
		return getInstance().findAllEmployee();
		
	}
	/*
	public static Employee findEmployeeById(int id){
		return getInstance().findEmployeeById(id);
	}
	public static Employee findEmployeeByPseudo(String pseudo)
	{
		return getInstance().findEmployeeByPseudo(pseudo);
	}*/


	
	/*
=======
	private static String jndiName="/erp-bank-ejb/EmployeeServices!services.interfaces.EmployeeServicesRemote";
	

	public static EmployeeServicesRemote getInstance() {

		return (EmployeeServicesRemote) ServiceLocator.getInstance()
				.getRemoteProxy(jndiName);
	}

	public static void ajouterEmploye(Employee employe)
	{
		getInstance().addEmployee(employe);
	}

	public static void supprimerEmploye(Employee employe) {
		getInstance().deleteEmployee(employe);
	}
	
	/*public static boolean findEmployee(String email, String pwd)
	{
		 return getInstance().
		
	}*/
	public static List<Employee> EmployeeList()
	{
		return getInstance().findAllEmployee();
		
	}

	/*public static Employee findEmployeeByPseudo(String pseudo)
	{
		return getInstance().findEmployeeByPseudo(pseudo);
	}*/
	public static void editemployee(Employee e) {
		getInstance().updateEmployee(e);
	}/*
	public static List<Employee> emplyees(String username){
		return getInstance().emplyees(username);
		
	}
>>>>>>> branch 'master' of https://github.com/HayfaNEGRA/erp-bank-repo.git
	public static Employee findEmployeeInventory(String user, String pass)
	{
		return getInstance().findEmployeeInventory(user, pass);
		
	}*/

}
