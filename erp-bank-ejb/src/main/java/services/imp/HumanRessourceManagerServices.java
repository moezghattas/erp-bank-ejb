package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.HumanRessourceManager;
import services.interfaces.HumanRessourceManagerServicesLocal;
import services.interfaces.HumanRessourceManagerServicesRemote;

/**
 * Session Bean implementation class HumanRessourceManagerServices
 */
@Stateless
@LocalBean
public class HumanRessourceManagerServices implements HumanRessourceManagerServicesRemote, HumanRessourceManagerServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public HumanRessourceManagerServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addhumanressource_manager(HumanRessourceManager humanressource_manager) {
   		Boolean b = false;
   				try {
   					entityManager.persist(humanressource_manager);
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	@Override
   	public Boolean deletehumanressource_managerById(Integer id) {
   		Boolean b = false;
   				try {
   					entityManager.remove(findhumanressource_managerById(id));
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	@Override
   	public HumanRessourceManager findhumanressource_managerById(Integer id) {
   		return entityManager.find(HumanRessourceManager.class, id);
   		
   	}

   	@Override
   	public Boolean updatehumanressource_manager(HumanRessourceManager humanressource_manager) {
   		
   		Boolean b = false;
   				try {
   					entityManager.merge(humanressource_manager);
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	@Override
   	public Boolean deletehumanressource_manager(HumanRessourceManager humanressource_manager) {
   		Boolean b = false;
   				try {
   					entityManager.remove(entityManager.merge(humanressource_manager));
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	
   	@Override
   	public List<HumanRessourceManager> findAllHumanRessourceManager() {
   		String jpql = "select e from HumanRessourceManager e";
   				Query query = entityManager.createQuery(jpql);
   				return query.getResultList();
   	}


}
