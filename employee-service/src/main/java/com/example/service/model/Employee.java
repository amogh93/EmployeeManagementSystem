package com.example.service.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String firstName;
	
	private String middleName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date joiningDate;
	
	@Temporal(TemporalType.DATE)
	private Date releivingDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dateOfBirth;
	
	@Column(nullable = false)
	private String emailAddress;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String permanentAddress;
	
	private String correspondenceAddress;
	
	@Column(nullable = false)
	private char gender;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getReleivingDate() {
		return releivingDate;
	}

	public void setReleivingDate(Date releivingDate) {
		this.releivingDate = releivingDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
