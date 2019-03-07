package com.cg.banking.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
@Controller
public class BankingServicesController {

	@Autowired
	BankingServices bankingServices;

	@RequestMapping("/registerAccount")
	public ModelAndView createAccount(@ModelAttribute Account account)throws InvalidAmountException{
		account=bankingServices.openAccount(account);
		return new ModelAndView("registrationSuccessPage","account",account);
	}
	@RequestMapping("/loginAccept")
	public ModelAndView loginValidation(@RequestParam  int accountNo ,int pinNumber)throws AccountNotFoundException,InvalidPinNumberException {
		bankingServices.pinVerify(accountNo, pinNumber);
		Account account=bankingServices.getAccountDetails(accountNo);
		return new ModelAndView("accountOperationsPage","account",account);
	}

	@RequestMapping("/depositAmountAccept") 
	public ModelAndView depositAmount(@RequestParam int accountNo,float amount) throws AccountNotFoundException,InvalidAmountException{
		Account account=bankingServices.depositAmount(accountNo, amount);
		return new ModelAndView("depositAmountPage","account",account); 
	}

	@RequestMapping("/withdrawAmountAccept") 
	public ModelAndView withdrawAmount(@RequestParam int accountNo,float amount)throws AccountNotFoundException,InsufficentAmountException {
		Account account=bankingServices.withdrawAmount(accountNo, amount);
		return new ModelAndView("withdrawAmountPage","account",account); 
	}

	@RequestMapping("/fundTransferAccept") 
	public ModelAndView fundTransfer(@RequestParam int accountNoTo,int accountNoFrom,float amount)throws AccountNotFoundException,InsufficentAmountException {
		bankingServices.fundTransfer(accountNoTo, accountNoFrom, amount);
		Account account=bankingServices.getAccountDetails(accountNoFrom);
		return  new ModelAndView("transferSuccessPage","account",account); 
	}
	@RequestMapping("/accountDetailsAccept")
	public ModelAndView displayAccountDetails(@RequestParam  int accountNo)throws AccountNotFoundException {
		Account account=bankingServices.getAccountDetails(accountNo);
		return new ModelAndView("displayAccountDetailsPage","account",account);
	}

}
