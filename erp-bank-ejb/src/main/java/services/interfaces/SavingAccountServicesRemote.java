package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.SavingAccount;

@Remote
public interface SavingAccountServicesRemote {
Boolean addSavingAccount(SavingAccount savingAccount);
	
	Boolean deleteSavingAccountById(Integer id);

	SavingAccount findSavingAccountById(Integer id);

	Boolean updateSavingAccount(SavingAccount savingAccount);

	Boolean deleteSavingAccount(SavingAccount savingAccount);

	List<SavingAccount> findAllSavingAccount();

}
