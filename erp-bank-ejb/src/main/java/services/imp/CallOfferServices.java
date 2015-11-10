package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CallOffer;
import services.interfaces.CallOfferServicesLocal;
import services.interfaces.CallOfferServicesRemote;

/**
 * Session Bean implementation class CallOfferServices
 */
@Stateless
@LocalBean
public class CallOfferServices implements CallOfferServicesRemote, CallOfferServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CallOfferServices() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean addcall_offer(CallOffer call_offer) {
		Boolean b = false;
				try {
					entityManager.persist(call_offer);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deletecall_offerById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findcall_offerById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public CallOffer findcall_offerById(Integer id) {
		return entityManager.find(CallOffer.class, id);
		
	}

	@Override
	public Boolean updatecall_offer(CallOffer call_offer) {
		
		Boolean b = false;
				try {
					entityManager.merge(call_offer);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deletecall_offer(CallOffer call_offer) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(call_offer));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	
	@Override
	public List<CallOffer> findAllCallOffer() {
		String jpql = "select e from CallOffer e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}

}
