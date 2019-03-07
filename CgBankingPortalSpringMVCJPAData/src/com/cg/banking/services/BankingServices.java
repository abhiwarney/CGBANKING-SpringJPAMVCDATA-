package com.cg.banking.services;
import java.util.List;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
public interface BankingServices {
	int generatePin();
	void pinVerify(int accountNo, int pinNumber) throws InvalidPinNumberException;
	Account openAccount(Account account)
			throws InvalidAmountException,InvalidAccountTypeException,BankingServicesDownException;

	Account depositAmount(int accountNo,float amount)
			throws AccountNotFoundException,BankingServicesDownException,AccountBlockedException;

	Account withdrawAmount(int accountNo,float amount)
			throws InsufficentAmountException,BankingServicesDownException,AccountBlockedException;

	void fundTransfer(int accountNoTo,int accountNoFrom,float transferAmount)
			throws InsufficentAmountException,BankingServicesDownException,AccountBlockedException;

	Account getAccountDetails(int accountNo)
			throws AccountNotFoundException;

	List<Account> getAllAccountDetails()
			throws BankingServicesDownException;

	List<Transaction> getAccountAllTransaction(int accountNo)
			throws BankingServicesDownException,AccountNotFoundException;

	public String accountStatus(int accountNo)
			throws BankingServicesDownException,AccountNotFoundException,AccountBlockedException;
}
