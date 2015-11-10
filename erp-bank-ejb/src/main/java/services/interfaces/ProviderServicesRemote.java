package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Provider;

@Remote
public interface ProviderServicesRemote {
Boolean addprovider(Provider provider);
	
	Boolean deleteproviderById(Integer id);

	Provider findproviderById(Integer id);

	Boolean updateprovider(Provider provider);

	Boolean deleteprovider(Provider provider);

	List<Provider> findAllProvider();
}
