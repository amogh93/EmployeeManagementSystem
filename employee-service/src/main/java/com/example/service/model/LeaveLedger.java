package com.example.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LeaveLedger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_ledg_seq")
	@SequenceGenerator(name = "leave_ledg_seq", sequenceName = "leave_ledg_seq", initialValue = 1, allocationSize=1)
	private int id;
	
	private int casualLeaves;
	
	private int sickLeaves;
	
	@OneToOne
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCasualLeaves() {
		return casualLeaves;
	}

	public void setCasualLeaves(int casualLeaves) {
		this.casualLeaves = casualLeaves;
	}

	public int getSickLeaves() {
		return sickLeaves;
	}

	public void setSickLeaves(int sickLeaves) {
		this.sickLeaves = sickLeaves;
	}

	@JsonBackReference
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
