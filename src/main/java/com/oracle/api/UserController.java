package com.oracle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.Customer;
import com.oracle.entity.Employee;
import com.oracle.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/")

public class UserController {
	
	@Autowired
	UserService authService;
	
	@GetMapping("/login/{username}/{password}")
	public String login(@PathVariable String username, @PathVariable String password) {
		return authService.loginService(username, password);
	}
	
	@PostMapping("/register/{username}/{password}")
	public Customer register(@RequestBody Customer customer, @PathVariable String username, @PathVariable String password) {
		return authService.registerService(customer, username, password);
	}
	
	@GetMapping("/user/{username}")
	public String getUserMemberId(@PathVariable String username) {
		return authService.getUserMemberIdService(username);
	}
	
	@PostMapping("/user/update/email/{email}/{member_id}/{role}")
	public boolean  updateUserEmail(@PathVariable String email, @PathVariable String member_id, @PathVariable String role) {
		return authService.updateUserEmailService(email, member_id, role);
	}
	
	@PostMapping("/user/update/contact/{contact}/{member_id}/{role}")
	public boolean  updateUserContact(@PathVariable long contact, @PathVariable String member_id, @PathVariable String role) {
		return authService.updateUserContactService(contact, member_id, role);
	}
	
	@PostMapping("/user/update/password/{password}/{member_id}")
	public boolean  updateUserPassword(@PathVariable String password, @PathVariable String member_id) {
		return authService.updateUserPasswordService(password, member_id);
	}
	
	@PostMapping("/user/customer/{username}")
	public Customer  getUserFromUsername(@PathVariable String username) {
		return authService.getCustomerFromUsernameService(username);
	}
	
	@PostMapping("/user/employee/{username}")
	public Employee  getEmployeeFromUsername(@PathVariable String username) {
		return authService.getEmployeeFromUsernameService(username);
	}
}
