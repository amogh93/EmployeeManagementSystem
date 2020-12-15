package com.example.service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public String authenticate(Authentication authentication)
	{
		UserDetails userDetails=(UserDetails)authentication.getPrincipal();
		System.out.println("authenticate called for user: "+userDetails.getUsername());
		return "authenticated";
	}
}
