package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.BankAccount;
import services.interfaces.BankAccountServicesLocal;
import services.interfaces.BankAccountServicesRemote;

/**
 * Session Bean implementation class BankAccountServices
 */
@Stateless
public class BankAccountServices implements BankAccountServicesRemote, BankAccountServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public BankAccountServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addBankAccount(BankAccount bankAccount) {
  		Boolean b = false;
  				
  					entityManager.persist(bankAccount);
  					b = true;
  				
  				return b;
  	}

  	public Boolean deleteBankAccountById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findBankAccountById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	
  	public BankAccount findBankAccountById(Integer id) {
  		return entityManager.find(BankAccount.class, id);
  		
  	}

  	public Boolean updateBankAccount(BankAccount bankAccount) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(bankAccount);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	public Boolean deleteBankAccount(BankAccount bankAccount) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(bankAccount));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	
  	public List<BankAccount> findAllBankAccount() {
  		String jpql = "select e from BankAccount e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}
	

}
