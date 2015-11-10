package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Customer;

@Remote
public interface CustomerServicesRemote {
	
    Boolean addCustomer(Customer customer);
	
	Boolean deleteCustomerById(Integer id);

	Customer findCustomerById(Integer id);

	Boolean updateCustomer(Customer customer);

	Boolean deleteCustomer(Customer customer);

	List<Customer> findAllCustomer();

}
