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
	public List<LoanApplication> searchLoanApplicationByTypeService(int loan_code) {
		List<LoanApplication> result = new ArrayList<LoanApplication>();
		try {
			result = loanDao.searchLoanApplicationByType(loan_code);
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

@Override
public List<LoanApplication> cancelLoanApplicationService(String loan_application_number) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.cancelLoanApplication(loan_application_number);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "The loan application that you are trying to delete is nowhere to be found";
		throw new LoanApplicationException(msg);
	}
	return result;
}

@Override
public List<LoanApplication> approveOrRejectLoanApplicationService(String loan_application_number, String value) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.approveOrRejectLoanApplication(loan_application_number, value);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "The loan application that you are trying to "+ value +" is nowhere to be found";
		throw new LoanApplicationException(msg);
	}
	return result;
}

}
