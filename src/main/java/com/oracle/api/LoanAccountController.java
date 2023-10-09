package com.oracle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.CustomerTransactions;
import com.oracle.entity.LoanAccount;
import com.oracle.entity.LoanBalance;
import com.oracle.service.LoanAccountService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoanAccountController {
	
	@Autowired
	LoanAccountService loanAccountService;
	
	@PostMapping("/loanAccount/accounts/{customer_id}")
	public List<LoanAccount> getAllLoanAccounts(@PathVariable String customer_id){
		return loanAccountService.getAllLoanAccountsService(customer_id);
	}
	
	@PostMapping("/loanAccount/transactions/customer/{customer_id}")
	public List<CustomerTransactions> getAllTransactionsForCustomer(@PathVariable String customer_id){
		return loanAccountService.getAllTransactionsForCustomerService(customer_id);
	}
	
	@PostMapping("/loanAccount/transactions/account/{loan_account_number}")
	public List<CustomerTransactions> getAllTransactionsForAccount(@PathVariable String loan_account_number){
		return loanAccountService.getAllTransactionsForAccountService(loan_account_number);
	}
	
	@PostMapping("/loanAccount/get/{loan_account_number}")
	public LoanAccount getLoanAccountByNumber(@PathVariable String loan_account_number){
		return loanAccountService.getLoanAccountByNumberService(loan_account_number);
	}
	
	@PostMapping("/loanAccount/transaction/{loan_account_number}/{amount}")
	public boolean makeTransaction(@PathVariable String loan_account_number,@PathVariable double amount) {
		return loanAccountService.makeTransactionService(loan_account_number, amount);
	}
	
	@PostMapping("loanBalance/get/{loan_account_number}")
	public LoanBalance getLoanBalance(@PathVariable String loan_account_number) {
		return loanAccountService.getLoanBalanceService(loan_account_number);
	}
	
	@PostMapping("loanBalance/get/customer/{customer_id}")
	public List<LoanBalance> getLoanBalanceCustomer(@PathVariable String customer_id) {
		return loanAccountService.getLoanBalanceCustomerService(customer_id);
	}
}
