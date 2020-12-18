package com.example.service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LeaveRequest 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_req_seq")
	@SequenceGenerator(name = "leave_req_seq", sequenceName = "leave_req_seq", initialValue = 1, allocationSize=1)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	private String reason;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate=new Date();
	
	private char approvalStatus;
	
	private int leaveType;
	
	private int duration;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date approvalDate;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "approver_id")
	private Employee approver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public char getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(char approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(int leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * Difference between from_date and to_date
	 * @return difference in days
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Difference between from_date and to_date
	 * @param duration in days
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@JsonBackReference
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@JsonBackReference(value = "approver")
	public Employee getApprover() {
		return approver;
	}

	public void setApprover(Employee approver) {
		this.approver = approver;
	}
}
