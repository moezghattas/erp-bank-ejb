package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.AccountCreationRequest;
import services.interfaces.AccountCreationRequestServicesLocal;
import services.interfaces.AccountCreationRequestServicesRemote;

/**
 * Session Bean implementation class AccountCreationRequestServices
 */
@Stateless
public class AccountCreationRequestServices implements AccountCreationRequestServicesRemote, AccountCreationRequestServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public AccountCreationRequestServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addAccountCreationRequest( AccountCreationRequest accountCreationRequest) {
		Boolean b = false;
				
					entityManager.persist(accountCreationRequest);
					b = true;
				
				return b;
	}
    public Boolean deleteAccountCreationRequestById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findAccountCreationRequestById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	
	public AccountCreationRequest findAccountCreationRequestById(Integer id) {
		return entityManager.find(AccountCreationRequest.class, id);
		
	}
	

	public Boolean updateAccountCreationRequest(AccountCreationRequest accountCreationRequest) {
		
		Boolean b = false;
				try {
					entityManager.merge(accountCreationRequest);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}
	
	public Boolean deleteAccountCreationRequest(AccountCreationRequest accountCreationRequest) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(accountCreationRequest));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	
	public List<AccountCreationRequest> findAllAccountCreationRequest() {
		String jpql = "select e from AccountCreationRequest e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}
	
	
	
	
	
	

}
