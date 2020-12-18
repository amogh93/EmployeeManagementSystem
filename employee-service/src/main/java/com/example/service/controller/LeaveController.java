package com.example.service.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.jpa.EmployeeRepository;
import com.example.service.jpa.LeaveRequestRepository;
import com.example.service.model.Employee;
import com.example.service.model.LeaveRequest;
import com.example.service.model.MyUserDetails;

@RestController
@RequestMapping("/api/v1/leave")
@CrossOrigin("http://localhost:4200")
public class LeaveController 
{
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	public String addLeaveRequest(@RequestBody LeaveRequest leaveRequest,Authentication authentication)
	{
		MyUserDetails userDetails=(MyUserDetails)authentication.getPrincipal();
		Optional<Employee> empOptional=employeeRepository.findById(userDetails.getEmployeeId());
		if(empOptional.isPresent())
		{
			long diff = leaveRequest.getToDate().getTime() - leaveRequest.getFromDate().getTime();
		    Long duration=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			leaveRequest.setEmployee(empOptional.get());
			leaveRequest.setDuration(duration.intValue());
			leaveRequest.setApprovalStatus('A');
			leaveRequestRepository.save(leaveRequest);
		}
		return "success";
	}
	
	@GetMapping
	public Set<LeaveRequest> getLeaveRequests(Authentication authentication)
	{
		Set<LeaveRequest> leaveRequests=new HashSet<LeaveRequest>();
		MyUserDetails userDetails=(MyUserDetails)authentication.getPrincipal();
		Optional<Employee> empOptional=employeeRepository.findById(userDetails.getEmployeeId());
		if(empOptional.isPresent())
		{
			leaveRequests.addAll(empOptional.get().getLeaveRequests());
		}
		return leaveRequests;
	}
}
