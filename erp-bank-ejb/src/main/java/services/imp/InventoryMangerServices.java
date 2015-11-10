package services.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entities.InventoryManager;
import services.interfaces.InventoryMangerServicesLocal;
import services.interfaces.InventoryMangerServicesRemote;

/**
 * Session Bean implementation class InventoryMangerServices
 */
@Stateless
@LocalBean
public class InventoryMangerServices implements InventoryMangerServicesRemote, InventoryMangerServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public InventoryMangerServices() {
        // TODO Auto-generated constructor stub
    }
    @Override
   	public Boolean addinventory_manager(InventoryManager inventory_manager) {
   		Boolean b = false;
   				try {
   					entityManager.persist(inventory_manager);
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	@Override
   	public Boolean deleteinventory_managerById(Integer id) {
   		Boolean b = false;
   				try {
   					entityManager.remove(findinventory_managerById(id));
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	@Override
   	public InventoryManager findinventory_managerById(Integer id) {
   		return entityManager.find(InventoryManager.class, id);
   		
   	}

   	@Override
   	public Boolean updateinventory_manager(InventoryManager inventory_manager) {
   		
   		Boolean b = false;
   				try {
   					entityManager.merge(inventory_manager);
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	@Override
   	public Boolean deleteinventory_manager(InventoryManager inventory_manager) {
   		Boolean b = false;
   				try {
   					entityManager.remove(entityManager.merge(inventory_manager));
   					b = true;
   				} catch (Exception e) {
   					System.err.println("ouups ...");
   				}
   				return b;
   	}

   	
   	@Override
   	public List<InventoryManager> findAllInventoryManager() {
   		String jpql = "select e from InventoryManager e";
   				Query query = entityManager.createQuery(jpql);
   				return query.getResultList();
   	}

}
