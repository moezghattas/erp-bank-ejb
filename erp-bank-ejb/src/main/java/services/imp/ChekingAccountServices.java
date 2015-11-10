package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.ChekingAccount;
import services.interfaces.ChekingAccountServicesLocal;
import services.interfaces.ChekingAccountServicesRemote;

/**
 * Session Bean implementation class ChekingAccountServices
 */
@Stateless
public class ChekingAccountServices implements ChekingAccountServicesRemote, ChekingAccountServicesLocal {
@PersistenceContext
private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ChekingAccountServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addChekingAccount(ChekingAccount chekingAccount) {
  		Boolean b = false;
  				
  					entityManager.persist(chekingAccount);
  					b = true;
  				
  				return b;
  	}

  	public Boolean deleteChekingAccountById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findChekingAccountById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	
  	public ChekingAccount findChekingAccountById(Integer id) {
  		return entityManager.find(ChekingAccount.class, id);
  		
  	}

  	public Boolean updateChekingAccount(ChekingAccount chekingAccount) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(chekingAccount);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	public Boolean deleteChekingAccount(ChekingAccount chekingAccount) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(chekingAccount));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	
  	public List<ChekingAccount> findAllChekingAccount() {
  		String jpql = "select e from ChekingAccount e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}


}
