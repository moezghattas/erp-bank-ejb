package entities;

import entities.Employee;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: InventoryManager
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class InventoryManager extends Employee implements Serializable {

	private List<CallOffer> calloffers;
	private List<Materials> materials;
	private static final long serialVersionUID = 1L;

	public InventoryManager() {
		super();
	}
	@OneToMany(mappedBy="inventory_Manager")
	public List<CallOffer> getCalloffers() {
		return calloffers;
	}

	public void setCalloffers(List<CallOffer> calloffers) {
		this.calloffers = calloffers;
	}
	@OneToMany(mappedBy="inventory_Manager")
	public List<Materials> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Materials> materials) {
		this.materials = materials;
	}
   
}
