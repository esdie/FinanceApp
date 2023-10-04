package com.oracle.service;

import java.util.List;

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;

public interface LoanService {
	public List<Loans> getLoansService();
	public List<LoanApplication> getAllLoanApplicationService();
	public List<LoanApplication> searchLoanApplicationByDateService(String start_date, String end_date);
	public List<LoanApplication> searchLoanApplicationByNumberService(String loan_application_number);
	public List<LoanApplication> searchLoanApplicationByTypeService(int loan_code);
	public List<LoanApplication> cancelLoanApplicationService(String loan_application_number);
	public List<LoanApplication> approveOrRejectLoanApplicationService(String loan_application_number, String value);
	public LoanApplication applyLoan(LoanApplication a);
}
