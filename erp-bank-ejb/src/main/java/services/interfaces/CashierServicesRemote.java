package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Cashier;

@Remote
public interface CashierServicesRemote {

	Boolean addCashier(Cashier cashier);
	
	Boolean deleteCashierById(Integer id);

	Cashier findCashierById(Integer id);

	Boolean updateCashier(Cashier cashier);

	Boolean deleteCashier(Cashier cashier);

	List<Cashier> findAllCashier();

}
