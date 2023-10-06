package com.oracle.service;

import com.oracle.entity.Customer;

public interface AuthenticationService {
	public String loginService(String username, String password);
	public Customer registerService(Customer customer, String username, String password);
}
