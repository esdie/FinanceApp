package com.oracle.dao;

import com.oracle.entity.Customer;

public interface AuthenticationDao {
	public String login(String username, String password);
	public Customer register(Customer customer, String username, String password);
	public String getUserMemberId(String role);
}
