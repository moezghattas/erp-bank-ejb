package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.SavingAccount;
import services.interfaces.SavingAccountServicesLocal;
import services.interfaces.SavingAccountServicesRemote;

/**
 * Session Bean implementation class SavingAccountServices
 */
@Stateless
public class SavingAccountServices implements SavingAccountServicesRemote, SavingAccountServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
	
    public SavingAccountServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addSavingAccount(SavingAccount savingAccount) {
  		Boolean b = false;
  				
  					entityManager.persist(savingAccount);
  					b = true;
  				
  				return b;
  	}

  	public Boolean deleteSavingAccountById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findSavingAccountById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	
  	public SavingAccount findSavingAccountById(Integer id) {
  		return entityManager.find(SavingAccount.class, id);
  		
  	}

  	public Boolean updateSavingAccount(SavingAccount savingAccount) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(savingAccount);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	public Boolean deleteSavingAccount(SavingAccount savingAccount) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(savingAccount));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	
  	public List<SavingAccount> findAllSavingAccount() {
  		String jpql = "select e from SavingAccount e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}


}
