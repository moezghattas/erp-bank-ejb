package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Provider;


@Local
public interface ProviderServicesLocal {
Boolean addprovider(Provider provider);
	
	Boolean deleteproviderById(Integer id);

	Provider findproviderById(Integer id);

	Boolean updateprovider(Provider provider);

	Boolean deleteprovider(Provider provider);

	List<Provider> findAllProvider();
}
