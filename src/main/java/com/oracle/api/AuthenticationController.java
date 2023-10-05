package com.oracle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
