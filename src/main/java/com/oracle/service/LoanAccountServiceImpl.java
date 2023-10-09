package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.dao.LoanAccountDao;
import com.oracle.entity.CustomerTransactions;
import com.oracle.entity.LoanAccount;
import com.oracle.entity.LoanApplication;
import com.oracle.entity.LoanBalance;
import com.oracle.exception.LoanApplicationException;

@Component
public class LoanAccountServiceImpl implements LoanAccountService{
	
	@Autowired
	LoanAccountDao loanAccountDao;
	@Override
	public List<LoanAccount> getAllLoanAccountsService(String customer_id) {
		List<LoanAccount> res;
		try {
			res = loanAccountDao.getAllLoanAccounts(customer_id);
			if(res.size() == 0) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find Loan Accounts";
			throw new LoanApplicationException(msg);
		}
		return res;
	}
	@Override
	public List<CustomerTransactions> getAllTransactionsForCustomerService(String customer_id) {
		List<CustomerTransactions> res;
		try {
			res = loanAccountDao.getAllTransactionsForCustomer(customer_id);
			if(res.size() == 0) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find Loan Accounts";
			throw new LoanApplicationException(msg);
		}
		return res;
	}
	@Override
	public List<CustomerTransactions> getAllTransactionsForAccountService(String loan_account_number) {
		List<CustomerTransactions> res;
		try {
			res = loanAccountDao.getAllTransactionsForAccount(loan_account_number);
			if(res.size() == 0) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find transactions";
			throw new LoanApplicationException(msg);
		}
		return res;
	}
	@Override
	public LoanAccount getLoanAccountByNumberService(String loan_account_number) {
		LoanAccount res = null;
		try {
			res = loanAccountDao.getAllLoanAccountByNumber(loan_account_number);
			if(res == null) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find Loan Accounts";
			throw new LoanApplicationException(msg);
		}
		return res;
	}
	@Override
	public boolean makeTransactionService(String loan_account_number, double amount) {
		boolean res = false;
		try {
			res = loanAccountDao.makeTransaction(loan_account_number, amount);
			if(res == false) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find Loan Accounts";
			throw new LoanApplicationException(msg);
		}
		return res;
	}
	@Override
	public LoanBalance getLoanBalanceService(String loan_account_number) {
		LoanBalance res = null;
		try {
			res = loanAccountDao.getLoanBalance(loan_account_number);
			if(res == null) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find Loan Accounts";
			throw new LoanApplicationException(msg);
		}
		return res;

	}
	@Override
	public List<LoanBalance> getLoanBalanceCustomerService(String customer_id) {
		List<LoanBalance> res;
		try {
			res = loanAccountDao.getLoanBalanceCustomer(customer_id);
			if(res.size() == 0) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "Could not find Loan Accounts";
			throw new LoanApplicationException(msg);
		}
		return res;
	}

}
