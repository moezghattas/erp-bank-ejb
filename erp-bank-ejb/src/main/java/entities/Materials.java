package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Materials
 *
 */
@Entity

public class Materials implements Serializable {

	
	public Materials() {
		super();
	}


	

	private int Id;
	private float price;
	private Date DeliveyDate;
	private String MaterialState;
	private InventoryManager Inventory_Manager;
	
	public Materials(int id, float price, Date deliveyDate, String materialState) {
		super();
		Id = id;
		this.price = price;
		DeliveyDate = deliveyDate;
		MaterialState = materialState;
	}

	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDeliveyDate() {
		return DeliveyDate;
	}
	public void setDeliveyDate(Date deliveyDate) {
		DeliveyDate = deliveyDate;
	}
	public String getMaterialState() {
		return MaterialState;
	}
	public void setMaterialState(String materialState) {
		MaterialState = materialState;
	}


	private static final long serialVersionUID = 1L;

	
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	@ManyToOne
	@JoinColumn(name="Id_Materials")
	public InventoryManager getInventory_Manager() {
		return Inventory_Manager;
	}


	public void setInventory_Manager(InventoryManager inventory_Manager) {
		Inventory_Manager = inventory_Manager;
	}
	
   
}
