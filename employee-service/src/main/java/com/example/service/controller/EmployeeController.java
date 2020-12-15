package com.example.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.jpa.EmployeeRepository;
import com.example.service.model.Employee;
import com.example.service.model.User;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@GetMapping
	public String getEmployee()
	{
		return "works";
	}
	
	@PostMapping
	public String addEmployee(@RequestBody Employee employee)
	{
		System.out.println("Employee name: "+employee.getFirstName());
		User user=new User();
		user.setUserName(employee.getFirstName().toLowerCase()+"."+employee.getLastName().toLowerCase());
		user.setPassword("password");
		user.setRoles("USER");
		user.setActive(true);
		user.setEmployee(employee);
		employee.setUser(user);
		
		employeeRepository.save(employee);
		
		return "success";
	}
}
