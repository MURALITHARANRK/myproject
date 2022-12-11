package com.leave.leaveproject.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name", length=20, nullable=false, unique=false )
	private String firstName;
	@Column(name = "middle_name", length=20, nullable=false, unique=false )
	private String middleName;
	@Column(name = "last_name", length=20, nullable=false, unique=false )
	private String lastName;
	@Column(name = "date_of_birth", nullable=false)
	private Date dateOfBirth;
	@Column(name = "gender", nullable=false)
	private Gender gender;
	@Column(name = "joining_date", nullable=false)
	private Date joiningDate;
	@Column(name = "leaving_date", nullable=true)
	private Date leavingDate;
	@Column(name = "status", length=10, nullable=false, unique=false)
	private EMPSTATUS status;
	@Column(name = "location", length=50, nullable=false, unique=false)
	private EMPLOCATION location;
	
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
	public EMPSTATUS getStatus() {
		return status;
	}
	public void setStatus(EMPSTATUS status) {
		this.status = status;
	}
	public EMPLOCATION getLocation() {
		return location;
	}
	public void setLocation(EMPLOCATION location) {
		this.location = location;
	}
	
	
}
