package com.example.service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.model.MyUserDetails;

@RestController
public class HomeController 
{
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public String authenticate(Authentication authentication)
	{
		MyUserDetails userDetails=(MyUserDetails)authentication.getPrincipal();
		System.out.println("authenticate called for user: "+userDetails.getUsername()+" and employee id: "+userDetails.getEmployeeId());
		return "authenticated";
	}
}
