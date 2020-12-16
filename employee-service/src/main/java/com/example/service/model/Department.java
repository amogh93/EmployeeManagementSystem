package com.example.service.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dep_seq")
	@SequenceGenerator(name = "dep_seq", sequenceName = "dep_seq", initialValue = 1, allocationSize=1)
	private int id;
	
	@Column(unique = true,nullable = false)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate=new Date();
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Set<Employee> employee = new HashSet<Employee>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@JsonBackReference
	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
}
