package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Provider;
import services.interfaces.ProviderServicesLocal;
import services.interfaces.ProviderServicesRemote;

/**
 * Session Bean implementation class ProviderServices
 */
@Stateless
@LocalBean
public class ProviderServices implements ProviderServicesRemote, ProviderServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ProviderServices() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean addprovider(Provider provider) {
		Boolean b = false;
				try {
					entityManager.persist(provider);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteproviderById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findproviderById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Provider findproviderById(Integer id) {
		return entityManager.find(Provider.class, id);
		
	}

	@Override
	public Boolean updateprovider(Provider provider) {
		
		Boolean b = false;
				try {
					entityManager.merge(provider);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteprovider(Provider provider) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(provider));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findAllProvider() {
		String jpql = "select e from Provider e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}
}
