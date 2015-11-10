package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.BankAccount;

@Remote
public interface BankAccountServicesRemote {
Boolean addBankAccount(BankAccount bankAccount);
	
	Boolean deleteBankAccountById(Integer id);

	BankAccount findBankAccountById(Integer id);

	Boolean updateBankAccount(BankAccount bankAccount);

	Boolean deleteBankAccount(BankAccount bankAccount);

	List<BankAccount> findAllBankAccount();

}
