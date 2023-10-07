package com.oracle.dao;

import com.oracle.entity.Customer;

public interface UserDao {
	public String login(String username, String password);
	public Customer register(Customer customer, String username, String password);
	public String getUserMemberId(String role);
	public boolean updateUserEmail(String email, String member_id, String role);
	public boolean updateUserContact(long contact, String member_id, String role);
	public boolean updateUserPassword(String password, String member_id);
	public Customer getCustomerFromUsername(String username);
}
