package com.example.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.jpa.DesignationRepository;
import com.example.service.model.Designation;

@RestController
@RequestMapping("/api/v1/designation")
@CrossOrigin("http://localhost:4200")
public class DesignationController 
{
	@Autowired
	private DesignationRepository designationRepository;
	
	@GetMapping
	public List<Designation> getDesignations()
	{
		return designationRepository.findAll();
	}
}
