package com.oracle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.dao.LoanDao;
import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;
import com.oracle.exception.LoanApplicationException;

@Component
public class LoanServiceImpl implements LoanService{


	@Autowired
	public LoanDao loanDao;
	
	@Override
	public List<Loans> getLoansService() {
		return loanDao.getLoans();
	}

	@Override
	public List<LoanApplication> getAllLoanApplicationService() {
		List<LoanApplication> res;
		try {
			res = loanDao.getAllLoanApplication();
			if(res.size() == 0) throw new LoanApplicationException();
		}
		catch(Exception e) {
			e.printStackTrace();
			String msg = "List empty";
			throw new LoanApplicationException(msg);
		}
		return res;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByDateService(String start_date, String end_date) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByDate(start_date, end_date);
			if(result.size() == 0) throw new LoanApplicationException()	;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new LoanApplicationException(msg);
		}
		return result;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByNumberService(String loan_application_number) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByNumber(loan_application_number);
			if(result.size() == 0) throw new LoanApplicationException()	;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new LoanApplicationException(msg);
		}
		return result;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByTypeService(int type_code) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByType(type_code);
			if(result.size() == 0) throw new LoanApplicationException()	;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new LoanApplicationException(msg);
		}
		return result;
	}

@Override
	public LoanApplication applyLoan(LoanApplication a) {
		
		return loanDao.applyLoan(a);
	}

}
