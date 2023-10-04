package com.oracle.dao;

import java.util.List;

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;
import com.oracle.entity.*;
public interface LoanDao {
	 public List<Loans> getLoans();
	 public List<LoanApplication> getAllLoanApplication();

	 public List<LoanApplication> searchLoanApplicationByDate(String start_date, String end_date);
	 public List<LoanApplication> searchLoanApplicationByNumber(String loan_application_number);
	 public List<LoanApplication> searchLoanApplicationByType(int type_code);
	 
	 public LoanApplication applyLoan(LoanApplication a);
}
