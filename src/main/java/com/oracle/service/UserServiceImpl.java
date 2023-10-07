package com.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.dao.UserDao;
import com.oracle.entity.Customer;
import com.oracle.exception.LoanApplicationException;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao authDao;
	@Override
	public String loginService(String username, String password) {
		String result = null;
		try {
			result = authDao.login(username, password);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}
	@Override
	public Customer registerService(Customer customer, String username, String password) {
		Customer result = null;
		try {
			result = authDao.register(customer, username, password);
			if(result == null)
				throw new LoanApplicationException("Register not successful");
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}
	@Override
	public String getUserMemberIdService(String username) {
		String result = null;
		try {
			result = authDao.getUserMemberId(username);
			if(result == null)
				throw new LoanApplicationException("Invalid Credentials");
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}
	@Override
	public boolean updateUserEmailService(String email, String member_id, String role) {
		boolean result = false;
		try {
			result = authDao.updateUserEmail(email, member_id, role);
			if(!result)
				throw new LoanApplicationException("Invalid Credentials");
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}
	@Override
	public boolean updateUserContactService(long contact, String member_id, String role) {
		boolean result = false;
		try {
			result = authDao.updateUserContact(contact, member_id, role);
			if(result == false)
				throw new LoanApplicationException("Invalid Credentials");
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}
	@Override
	public boolean updateUserPasswordService(String password, String member_id) {
		boolean result = false;
		try {
			result = authDao.updateUserPassword(password, member_id);
			if(result == false)
				throw new LoanApplicationException("Password could not be updated");
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}
	@Override
	public Customer getCustomerFromUsernameService(String username) {
		Customer result = null;
		try {
			result = authDao.getCustomerFromUsername(username);
			if(result == null)
				throw new LoanApplicationException("Could not find customer");
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		return result;
	}

}
