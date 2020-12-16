package com.example.service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>
{

}
