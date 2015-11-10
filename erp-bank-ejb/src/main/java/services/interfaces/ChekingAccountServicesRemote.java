package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ChekingAccount;

@Remote
public interface ChekingAccountServicesRemote {
Boolean addChekingAccount(ChekingAccount chekingAccount);
	
	Boolean deleteChekingAccountById(Integer id);

	ChekingAccount findChekingAccountById(Integer id);

	Boolean updateChekingAccount(ChekingAccount chekingAccount);

	Boolean deleteChekingAccount(ChekingAccount chekingAccount);

	List<ChekingAccount> findAllChekingAccount();

}
