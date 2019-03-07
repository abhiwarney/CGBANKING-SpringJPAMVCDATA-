package com.cg.banking.services;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
@Component("bankingServices")
public class BankingServicesImpl implements BankingServices {
	int counter;
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private TransactionDAO transactionDao;
	@Override
	public int generatePin() {
		return (int)Math.pow(5, 5 - 1) + new Random().nextInt(9000);
	}
	@Override
	public void pinVerify(int accountNo,int pinNumber) throws AccountBlockedException,InvalidPinNumberException {
		Account account = getAccountDetails(accountNo);
		if(account.getAccountStatus()=="Blocked") {
			throw new AccountBlockedException("Account Blocked :"+accountNo);
		}
		else counter=0;
		if(pinNumber!=account.getPinNumber()) {
			if(counter>=3) {
				account.setAccountStatus("Blocked");
				throw new AccountBlockedException("Account Blocked :"+accountNo);
			}
			else {
				counter++;
				throw new InvalidPinNumberException("Invalid Pin Number. Please Enter a Valid PIN!");
			}
		}
	}
	@Override
	public Account openAccount(Account account)throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		if(account.getAccountBalance()<500)
			throw new InvalidAmountException("Minimum Balance should be 500:");
		account.setPinNumber(generatePin());
		account.setAccountStatus("Active");
		account = accountDao.save(account);
		return account;
	}
	@Override
	public Account depositAmount(int accountNo, float amount)throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		account.setAccountBalance(account.getAccountBalance() + amount);
		Transaction transaction = new Transaction(amount,"Deposit",account);
		transaction = transactionDao.save(transaction);
		account=accountDao.save(account);
		return account;
	}
	@Override
	public Account withdrawAmount(int accountNo, float amount) throws InsufficentAmountException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		if(amount>account.getAccountBalance())
			throw new InsufficentAmountException("Insufficient balance in your account!!");
		else
			account.setAccountBalance(account.getAccountBalance() - amount);
		Transaction transaction = new Transaction(amount,"Withdraw",account);
		transactionDao.save(transaction);
		account=accountDao.save(account);
		return account;
	}
	@Override
	public void fundTransfer(int accountNoTo, int accountNoFrom, float transferAmount)throws InsufficentAmountException,BankingServicesDownException, AccountBlockedException {
		withdrawAmount(accountNoFrom, transferAmount);
		depositAmount(accountNoTo, transferAmount);
	}
	@Override
	public Account getAccountDetails(int accountNo) throws AccountNotFoundException{
		Account account=accountDao.findById(accountNo).orElseThrow(()->new AccountNotFoundException("Account Not Found!!"));
		return account;
	}
	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return accountDao.findAll();
	}
	@Override
	public List<Transaction> getAccountAllTransaction(int accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		return (List<Transaction>) transactionDao.findById(accountNo).orElseThrow(()->new AccountNotFoundException("No transaction Found for accountNo:"+accountNo));
	}
	@Override
	public String accountStatus(int accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		if(account.getAccountStatus()=="Active")
			account.setAccountStatus("Blocked");
		else if(account.getAccountStatus()=="Blocked")
			account.setAccountStatus("Active");
		return account.getAccountStatus() ;
	}
}
