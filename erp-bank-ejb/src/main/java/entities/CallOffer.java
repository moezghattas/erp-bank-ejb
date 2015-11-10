package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CallOffer
 *
 */
@Entity
@Table(name="T_call_offer")

public class CallOffer implements Serializable {

	
	private Integer Id;
	private String Description;
	private  Provider provider ;
	private InventoryManager Inventory_Manager;
	private static final long serialVersionUID = 1L;

	public CallOffer() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	@ManyToOne
	@JoinColumn(name="id_prodvider")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	@ManyToOne
	@JoinColumn(name="id_Inventory_Manager")
	public InventoryManager getInventory_Manager() {
		return Inventory_Manager;
	}
	public void setInventory_Manager(InventoryManager inventory_Manager) {
		Inventory_Manager = inventory_Manager;
	}

   
}
