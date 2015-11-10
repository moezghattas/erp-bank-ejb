package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.AccountCreationRequest;

@Remote
public interface AccountCreationRequestServicesRemote {
    Boolean addAccountCreationRequest(AccountCreationRequest accountCreationRequest);
	
	Boolean deleteAccountCreationRequestById(Integer id);

	AccountCreationRequest findAccountCreationRequestById(Integer id);

	Boolean updateAccountCreationRequest(AccountCreationRequest accountCreationRequest);

	Boolean deleteAccountCreationRequest(AccountCreationRequest accountCreationRequest);

	List<AccountCreationRequest> findAllAccountCreationRequest();

}
