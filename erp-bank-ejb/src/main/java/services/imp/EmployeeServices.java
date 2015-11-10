package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employee;

import entities.HumanRessourceManager;
import entities.InventoryManager;
import services.interfaces.EmployeeServicesLocal;
import services.interfaces.EmployeeServicesRemote;

/**
 * Session Bean implementation class EmployeeServices
 */
@Stateless
@LocalBean
public class EmployeeServices implements EmployeeServicesRemote, EmployeeServicesLocal {
	@PersistenceContext(name = "gestionemploye")

	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public EmployeeServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEmployee(Employee employee) {
		Boolean b = false;
				try {
					entityManager.persist(employee);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteEmployeeById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findEmployeeById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return entityManager.find(Employee.class, id);
		
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		
		Boolean b = false;
				try {
					entityManager.merge(employee);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(employee));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployee() {
		String jpql = "select e from Employee e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}
	
	@Override
	public boolean identifIM(String email, String password) {
		
		boolean reponse = false;
		String jpql = "select e from Employee e where e.email =:e and e.password=:p ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("e", email).setParameter("p", password);
		Employee e = (Employee) query.getSingleResult();
		System.out.println(e.getClass());
		if (e instanceof InventoryManager)
		{
			reponse = true;
		}
		return reponse;
	}

	@Override
	public boolean identifHRM(String email, String password) {
		boolean reponse = false;
		String jpql = "select e from Employee e where e.email =:e and e.password=:p ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("e", email).setParameter("p", password);
		Employee e = (Employee) query.getSingleResult();
		System.out.println(e.getClass());
		if (e instanceof HumanRessourceManager)
		{
			reponse = true;
		}
		return reponse;
	}

	@Override
	public boolean identifITM(String email, String password) {
		
		return false;
	}

	@Override
	public boolean identifCA(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean identifCashier(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}


}
