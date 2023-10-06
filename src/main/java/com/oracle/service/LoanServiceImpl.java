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
	public LoanApplication searchLoanApplicationByNumberService(String loan_application_number) {
		LoanApplication result = null;
		try {
			result = loanDao.searchLoanApplicationByNumber(loan_application_number);
			//System.out.println("result: "+result);
			if(result == null) throw new LoanApplicationException()	;
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
			System.out.println(result);
			if(result.size() == 0) throw new LoanApplicationException()	;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "No applicaton found";
			throw new LoanApplicationException(msg);
		}
		return result;
	}

@Override
	public LoanApplication applyLoanService(LoanApplication a) {
		
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
public List<LoanApplication> rejectLoanApplicationService(String loan_application_number) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.rejectLoanApplication(loan_application_number);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "The loan application that you are trying to reject is nowhere to be found";
		throw new LoanApplicationException(msg);
	}
	return result;
}

@Override
public List<LoanApplication> approveLoanApplicationService(String loan_application_number, double amount_sanctioned, int tenure) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.approveLoanApplication(loan_application_number, amount_sanctioned, tenure);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "The loan application that you are trying to approve has already been approved";
		throw new LoanApplicationException(msg);
	}
	return result;
}

@Override
public List<LoanApplication> searchLoanApplicationByCustomerService(String customer_id) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.searchLoanApplicationByCustomer(customer_id);
		//System.out.println(result);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "No applicaton found";
		throw new LoanApplicationException(msg);
	}
	return result;
}

@Override
public List<LoanApplication> searchLoanApplicationByStatusService(String loan_status) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.searchLoanApplicationByStatus(loan_status);
		//System.out.println(result);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "No applicaton found";
		throw new LoanApplicationException(msg);
	}
	return result;
}

@Override
public List<LoanApplication> searchLoanApplicationByClerkIdService(String clerk_id) {
	List<LoanApplication> result = new ArrayList<LoanApplication>();
	try {
		result = loanDao.searchLoanApplicationByClerkId(clerk_id);
		System.out.println(result);
		if(result.size() == 0) throw new LoanApplicationException()	;
	} catch (Exception e) {
		e.printStackTrace();
		String msg = "No applicaton found with clerk id";
		throw new LoanApplicationException(msg);
	}
	return result;
}

}
