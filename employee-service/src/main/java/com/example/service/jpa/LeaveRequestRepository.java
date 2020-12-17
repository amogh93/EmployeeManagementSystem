package com.example.service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.model.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> 
{

}
