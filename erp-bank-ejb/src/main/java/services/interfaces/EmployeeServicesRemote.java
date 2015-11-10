package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServicesRemote {
Boolean addEmployee(Employee employee);
	
	Boolean deleteEmployeeById(Integer id);

	Employee findEmployeeById(Integer id);

	Boolean updateEmployee(Employee employee);

	Boolean deleteEmployee(Employee employee);

	public List<Employee> findAllEmployee();

	boolean identifIM(String email, String password);
	
	boolean identifHRM(String email, String password);
	
	boolean identifITM(String email, String password);
	
	boolean identifCA(String email, String password);
	
	boolean identifCashier(String email, String password);

}