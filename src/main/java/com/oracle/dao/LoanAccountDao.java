package com.oracle.dao;

import java.util.List;

import com.oracle.entity.CustomerTransactions;
import com.oracle.entity.LoanAccount;
import com.oracle.entity.LoanBalance;

public interface LoanAccountDao {
	public List<CustomerTransactions> getAllTransactionsForCustomer(String customer_id);
	public List<CustomerTransactions> getAllTransactionsForAccount(String loan_account_number);
	public List<LoanAccount> getAllLoanAccounts(String customer_id);
	public LoanAccount getAllLoanAccountByNumber(String loan_account_number);
	public boolean makeTransaction(String loan_account_number, double amount);
	public LoanBalance getLoanBalance(String loan_account_number);
	public List<LoanBalance> getLoanBalanceCustomer(String customer_id);
}
