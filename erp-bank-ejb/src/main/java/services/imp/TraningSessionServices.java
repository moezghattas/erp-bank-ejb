package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.TrainingSession;
import entities.TrainingSession;
import services.interfaces.TraningSessionServicesLocal;
import services.interfaces.TraningSessionServicesRemote;

/**
 * Session Bean implementation class TraningSessionServices
 */
@Stateless
@LocalBean
@PersistenceContext(name = "trainingsession")

public class TraningSessionServices implements TraningSessionServicesRemote, TraningSessionServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	

    /**
     * Default constructor. 
     */
    public TraningSessionServices() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public Boolean addtrainingsession(TrainingSession trainingsession) {
		Boolean b = false;
				try {
					entityManager.persist(trainingsession);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deletetrainingsessionById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findtrainingsessionById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public TrainingSession findtrainingsessionById(Integer id) {
		return entityManager.find(TrainingSession.class, id);
		
	}

	@Override
	public Boolean updatetrainingsession(TrainingSession trainingsession) {
		
		Boolean b = false;
				try {
					entityManager.merge(trainingsession);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deletetrainingsession(TrainingSession trainingsession) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(trainingsession));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainingSession> findAllTrainingSession() {
		String jpql = "select e from TrainingSession e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}
    
	}

	
