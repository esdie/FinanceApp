package com.oracle.service;

import java.util.List;

import com.oracle.entity.LoanBalance;
import com.oracle.entity.CustomerTransactions;
import com.oracle.entity.LoanAccount;

public interface LoanAccountService {

	public List<LoanAccount> getAllLoanAccountsService(String customer_id);

	public List<CustomerTransactions> getAllTransactionsForCustomerService(String customer_id);

	public List<CustomerTransactions> getAllTransactionsForAccountService(String loan_account_number);

	public LoanAccount getLoanAccountByNumberService(String loan_account_number);

	public boolean makeTransactionService(String loan_account_number, double amount);

	public LoanBalance getLoanBalanceService(String loan_account_number);

}
