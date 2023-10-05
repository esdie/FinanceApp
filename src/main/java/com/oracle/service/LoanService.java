package com.oracle.service;

import java.util.List;

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;

public interface LoanService {
	public List<Loans> getLoansService();
	public List<LoanApplication> getAllLoanApplicationService();
	public List<LoanApplication> searchLoanApplicationByDateService(String start_date, String end_date);
	public LoanApplication searchLoanApplicationByNumberService(String loan_application_number);
	public List<LoanApplication> searchLoanApplicationByTypeService(int loan_code);
	public List<LoanApplication> cancelLoanApplicationService(String loan_application_number);
	public List<LoanApplication> rejectLoanApplicationService(String loan_application_number);
	public List<LoanApplication> approveLoanApplicationService(String loan_application_number, double amount_sanctioned, int tenure);
	public LoanApplication applyLoan(LoanApplication a);
	public List<LoanApplication> searchLoanApplicationByCustomerService(String customer_id);
	
}
