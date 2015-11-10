package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Customer;
import services.interfaces.CustomerServicesLocal;
import services.interfaces.CustomerServicesRemote;

/**
 * Session Bean implementation class CustomerServices
 */
@Stateless
public class CustomerServices implements CustomerServicesRemote, CustomerServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CustomerServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addCustomer(Customer customer) {
  		Boolean b = false;
  				
  					entityManager.persist(customer);
  					b = true;
  				
  				return b;
  	}

  	public Boolean deleteCustomerById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findCustomerById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	
  	public Customer findCustomerById(Integer id) {
  		return entityManager.find(Customer.class, id);
  		
  	}

  	public Boolean updateCustomer(Customer customer) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(customer);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	public Boolean deleteCustomer(Customer customer) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(customer));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	
  	public List<Customer> findAllCustomer() {
  		String jpql = "select e from Customer e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}

}
