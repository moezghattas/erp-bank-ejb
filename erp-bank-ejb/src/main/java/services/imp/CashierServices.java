package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Cashier;
import services.interfaces.CashierServicesLocal;
import services.interfaces.CashierServicesRemote;

/**
 * Session Bean implementation class CashierServices
 */
@Stateless
public class CashierServices implements CashierServicesRemote, CashierServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CashierServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addCashier(Cashier cashier) {
  		Boolean b = false;
  				
  					entityManager.persist(cashier);
  					b = true;
  				
  				return b;
  	}

  	public Boolean deleteCashierById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findCashierById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	
  	public Cashier findCashierById(Integer id) {
  		return entityManager.find(Cashier.class, id);
  		
  	}

  	public Boolean updateCashier(Cashier cashier) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(cashier);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	public Boolean deleteCashier(Cashier cashier) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(cashier));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	
  	public List<Cashier> findAllCashier() {
  		String jpql = "select e from Cashier e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}


}
