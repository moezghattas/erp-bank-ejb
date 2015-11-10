package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CandidaciesDemands;
import services.interfaces.CandidaciesDemandsServicesLocal;
import services.interfaces.CandidaciesDemandsServicesRemote;

/**
 * Session Bean implementation class CandidaciesDemandsServices
 */
@Stateless
@LocalBean
public class CandidaciesDemandsServices implements CandidaciesDemandsServicesRemote, CandidaciesDemandsServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public CandidaciesDemandsServices() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean addcandidaciesdemands(CandidaciesDemands candidaciesdemands) {
		Boolean b = false;
				try {
					entityManager.persist(candidaciesdemands);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deletecandidaciesdemandsById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findcandidaciesdemandsById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public CandidaciesDemands findcandidaciesdemandsById(Integer id) {
		return entityManager.find(CandidaciesDemands.class, id);
		
	}

	@Override
	public Boolean updatecandidaciesdemands(CandidaciesDemands candidaciesdemands) {
		
		Boolean b = false;
				try {
					entityManager.merge(candidaciesdemands);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deletecandidaciesdemands(CandidaciesDemands candidaciesdemands) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(candidaciesdemands));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CandidaciesDemands> findAllCandidaciesDemands() {
		String jpql = "select e from CandidaciesDemands e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}

}
