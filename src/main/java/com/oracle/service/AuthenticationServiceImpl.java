package com.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.dao.AuthenticationDao;
import com.oracle.exception.LoanApplicationException;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	public AuthenticationDao authDao;
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

}
