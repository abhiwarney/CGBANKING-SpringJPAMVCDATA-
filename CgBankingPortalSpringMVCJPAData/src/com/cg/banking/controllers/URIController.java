package com.cg.banking.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.banking.beans.Account;
@Controller
public class URIController {
	Account account;
	@RequestMapping(value={"/","indexPage"})
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/registration")
	public String getRegisterationPage(){
		return "registrationPage";
	}
	@RequestMapping("/login")
	public String getLoginPage(){
		return "loginPage";
	}
	@RequestMapping("/deposit")
	public String getDepositAmountPage(){
		return "depositAmountPage";
	}
	@RequestMapping("/withdraw")
	public String getWithdrawAmountPage(){
		return "withdrawAmountPage";
	}
	@RequestMapping("/fundTransfer")
	public String getFundTransferPage(){
		return "fundTransferPage";
	}
	@RequestMapping("/accountDetails")
	public String getAccountDetails(){
		return "displayAccountDetailsPage";
	}
	@ModelAttribute
	public Account getAccount() {
		account = new Account();
		return account;
	}
}
