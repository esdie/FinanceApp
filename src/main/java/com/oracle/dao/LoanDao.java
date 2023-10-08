package com.oracle.dao;

import java.util.List;

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;
import com.oracle.entity.*;
public interface LoanDao {
	 public List<Loans> getLoans();
	 public List<LoanApplication> getAllLoanApplication();
	 public List<LoanApplication> searchLoanApplicationByDate(String start_date, String end_date);
	 public LoanApplication searchLoanApplicationByNumber(String loan_application_number);
	 public List<LoanApplication> searchLoanApplicationByType(int loan_code);
	 public List<LoanApplication> cancelLoanApplication(String loan_application_number);
	 public LoanApplication applyLoan(LoanApplication application);
	 public List<LoanApplication> rejectLoanApplication(String loan_application_number);
	 public List<LoanApplication> approveLoanApplication(String loan_application_number, double amount_sanctioned, int tenure);
	 public List<LoanApplication> searchLoanApplicationByCustomer(String customer_id);
	 public List<LoanApplication> searchLoanApplicationByStatus(String loan_status);
	 public List<LoanApplication> searchLoanApplicationByClerkId(String clerk_id);
	 public double getInterestRate(int loan_id);

}
