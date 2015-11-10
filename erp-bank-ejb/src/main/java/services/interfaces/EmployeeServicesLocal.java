package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Employee;

@Local
public interface EmployeeServicesLocal {
	Boolean addEmployee(Employee employee);
	
	Boolean deleteEmployeeById(Integer id);

	Employee findEmployeeById(Integer id);

	Boolean updateEmployee(Employee employee);

	Boolean deleteEmployee(Employee employee);

	List<Employee> findAllEmployee();
}
