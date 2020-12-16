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
import com.example.service.model.Department;

@RestController
@RequestMapping("/api/v1/department")
@CrossOrigin("http://localhost:4200")
public class DepartmentController 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public List<Department> getDepartments()
	{
		return departmentRepository.findAll();
	}
	
	@GetMapping("{departmentId}")
	public Department getDepartment(@PathVariable String departmentId)
	{
		Optional<Department> department=departmentRepository.findById(Integer.parseInt(departmentId));
		return department.get();
	}
	
	@PostMapping
	public String addDepartment(@RequestBody Department department)
	{
		departmentRepository.save(department);
		return "success";
	}
	
	@PutMapping("{departmentId}")
	public String updateDepartment(@PathVariable String departmentId,@RequestBody Department department)
	{
		System.out.println("Updating department "+department.getName());
		Optional<Department> depOptional=departmentRepository.findById(Integer.parseInt(departmentId));
		if(depOptional.isPresent())
		{
			Department updatedDepartment=depOptional.get();
			updatedDepartment.setName(department.getName());
			departmentRepository.save(updatedDepartment);
		}
		return "success";
	}
}
