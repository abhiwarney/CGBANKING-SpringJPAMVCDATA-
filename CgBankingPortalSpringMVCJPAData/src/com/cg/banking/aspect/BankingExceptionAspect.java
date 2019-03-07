package com.cg.banking.aspect;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
@ControllerAdvice
public class BankingExceptionAspect {
	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handleAccountNotFoundException(Exception e) {
		return new ModelAndView("loginPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(InvalidPinNumberException.class)
	public ModelAndView handleInvalidPinNumberException(Exception e) {
		return new ModelAndView("loginPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(InvalidAmountException.class)
	public ModelAndView handleInvalidAmountException(Exception e) {
		ModelAndView modelAndView=new ModelAndView("registrationPage", "errorMessage", e.getMessage());
		modelAndView.addObject("account",new Account());
		return modelAndView;
	}
	@ExceptionHandler(InsufficentAmountException.class)
	public ModelAndView handleInsufficentAmountException(Exception e) {
		return new ModelAndView("withdrawAmountPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(AccountBlockedException.class)
	public ModelAndView handleAccountBlockedException(Exception e) {
		return new ModelAndView("loginPage", "errorMessage", e.getMessage());
	}
}
