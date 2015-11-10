package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.InventoryManager;

@Remote
public interface InventoryMangerServicesRemote {
	
Boolean addinventory_manager(InventoryManager inventory_manager);
	
	Boolean deleteinventory_managerById(Integer id);

	InventoryManager findinventory_managerById(Integer id);

	Boolean updateinventory_manager(InventoryManager inventory_manager);

	Boolean deleteinventory_manager(InventoryManager inventory_manager);

	List<InventoryManager> findAllInventoryManager();
	
}
