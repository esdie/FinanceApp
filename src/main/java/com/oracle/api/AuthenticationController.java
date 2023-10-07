package com.oracle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.Customer;
import com.oracle.service.AuthenticationService;

@RestController
@CrossOrigin
@RequestMapping("/")

public class AuthenticationController {
	
	@Autowired
	AuthenticationService authService;
	
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
}
