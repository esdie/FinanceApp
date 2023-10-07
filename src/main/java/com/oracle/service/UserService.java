package com.oracle.service;

import com.oracle.entity.Customer;

public interface UserService {
	public String loginService(String username, String password);
	public Customer registerService(Customer customer, String username, String password);
	public String getUserMemberIdService(String username);
	public boolean updateUserEmailService(String email, String member_id, String role);
	public boolean updateUserContactService(long contact, String member_id, String role);
	public boolean updateUserPasswordService(String password, String member_id);
	public Customer getCustomerFromUsernameService(String username);

}
