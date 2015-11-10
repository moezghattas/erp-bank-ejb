package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Reward;
import services.interfaces.RewardServicesLocal;
import services.interfaces.RewardServicesRemote;

/**
 * Session Bean implementation class RewardServices
 */
@Stateless

public class RewardServices implements RewardServicesRemote, RewardServicesLocal {
	@PersistenceContext
private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RewardServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addreward(Reward reward) {
		Boolean b = false;
				
					entityManager.persist(reward);
					b = true;
				
				return b;
	}

	public Boolean deleterewardById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findrewardById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	
	public Reward findrewardById(Integer id) {
		return entityManager.find(Reward.class, id);
		
	}

	public Boolean updatereward(Reward reward) {
		
		Boolean b = false;
				try {
					entityManager.merge(reward);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	public Boolean deletereward(Reward reward) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(reward));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	
	public List<Reward> findAllReward() {
		String jpql = "select e from Reward e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}
}
