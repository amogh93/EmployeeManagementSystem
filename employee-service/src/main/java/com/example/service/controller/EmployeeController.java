package com.example.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.jpa.DepartmentRepository;
import com.example.service.jpa.DesignationRepository;
import com.example.service.jpa.EmployeeRepository;
import com.example.service.model.Department;
import com.example.service.model.Designation;
import com.example.service.model.Employee;
import com.example.service.model.User;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@GetMapping
	public List<Employee> getEmployees()
	{
		return employeeRepository.findAll();
	}
	
	@GetMapping("{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId)
	{
		Optional<Employee> employee=employeeRepository.findById(Integer.parseInt(employeeId));
		return employee.get();
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
		
		Optional<Department> depOptional=departmentRepository.findById(employee.getDepartment().getId());
		if(depOptional.isPresent())
		{
			employee.setDepartment(depOptional.get());
		}
		
		Optional<Designation> designOptional=designationRepository.findById(employee.getDesignation().getId());
		if(designOptional.isPresent())
		{
			employee.setDesignation(designOptional.get());
		}
		
		if(employee.getManager() != null && employee.getManager().getId() != 0)
		{
			Optional<Employee> empOptional=employeeRepository.findById(employee.getManager().getId());
			if(empOptional.isPresent())
			{
				employee.setManager(empOptional.get());
			}
		}
		
		employeeRepository.save(employee);
		
		return "success";
	}
	
	@PutMapping("{employeeId}")
	public String updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee)
	{
		System.out.println("Update for emp: "+employee.getFirstName());
		Optional<Employee> empOptional=employeeRepository.findById(Integer.parseInt(employeeId));
		if(empOptional.isPresent())
		{
			Employee employeeUpdate=empOptional.get();
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setMiddleName(employee.getMiddleName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setPermanentAddress(employee.getPermanentAddress());
			employeeUpdate.setCorrespondenceAddress(employee.getCorrespondenceAddress());
			employeeUpdate.setDateOfBirth(employee.getDateOfBirth());
			employeeUpdate.setJoiningDate(employee.getJoiningDate());
			employeeUpdate.setReleivingDate(employee.getReleivingDate());
			employeeUpdate.setPhoneNumber(employee.getPhoneNumber());
			employeeUpdate.setEmailAddress(employee.getEmailAddress());
			
			Optional<Department> depOptional=departmentRepository.findById(employee.getDepartment().getId());
			if(depOptional.isPresent())
			{
				employeeUpdate.setDepartment(depOptional.get());
			}
			
			Optional<Designation> designOptional=designationRepository.findById(employee.getDesignation().getId());
			if(designOptional.isPresent())
			{
				employeeUpdate.setDesignation(designOptional.get());
			}
			
			if(employee.getManager() != null && employee.getManager().getId() != 0)
			{
				Optional<Employee> mgrOptional=employeeRepository.findById(employee.getManager().getId());
				if(mgrOptional.isPresent())
				{
					employeeUpdate.setManager(mgrOptional.get());
				}
			}
			
			employeeRepository.save(employeeUpdate);
		}
		return "success";
	}
}
