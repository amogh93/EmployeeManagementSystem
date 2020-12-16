package com.example.service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.model.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> 
{

}
