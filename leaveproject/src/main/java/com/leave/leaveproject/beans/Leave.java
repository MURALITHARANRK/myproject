package com.leave.leaveproject.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Leave")
public class Leave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="from_date", nullable=false)
	private Date fromDate;
	@Column(name="to_date", nullable=false)
	private Date toDate;
	@Column(name="number_of_days", nullable=false)
	private int numberOfDays;
	@Column(name="requested_by", nullable=false)
	private int requestedBy;
	@CreationTimestamp
	@Column(name="requested_date", nullable=false, updatable=false)
	private Date requestedDate;
	@Column(name="approved_by", nullable=true)
	private int approvedBy;
	@CreationTimestamp
	@Column(name="approved_date", nullable=true, updatable=false)
	private Date approvedDate;
	
	
	
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
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public int getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(int requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Date getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	

}
