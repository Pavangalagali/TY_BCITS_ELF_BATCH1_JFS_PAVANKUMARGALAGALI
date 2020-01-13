package com.bcits.employeemanagementinfo.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name = "employee_secondary_info")
public class SecondaryInfo implements Serializable {
	@Id
	private int empId;
	@Column
	private String gender;
	@Column(name = "personal_maildid")
	private String personalEmail;
	@Column
	private int age;
	@Column
	private String nationality;
	@Column
	private String isMarried;
	@Column
	private String govtId;
	@Column
	private String guardianNname;
	@Column
	private long guardianContact;
	@Column
	private String jobLocation;

	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private PrimaryInfo primaryInfo;

	/*
	 * public PrimaryInfo getPrimaryInfo() { return primaryInfo; }
	 * 
	 * public void setPrimaryInfo(PrimaryInfo primaryInfo) { this.primaryInfo =
	 * primaryInfo; }
	 * 
	 * public int getEmpId() { return empId; }
	 * 
	 * public void setEmpId(int empId) { this.empId = empId; }
	 * 
	 * public String getGender() { return gender; }
	 * 
	 * public void setGender(String gender) { this.gender = gender; }
	 * 
	 * public String getPersonalEmail() { return personalEmail; }
	 * 
	 * public void setPersonalEmail(String personalEmail) { this.personalEmail =
	 * personalEmail; }
	 * 
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 * 
	 * public String getNationality() { return nationality; }
	 * 
	 * public void setNationality(String nationality) { this.nationality =
	 * nationality; }
	 * 
	 * public String getIsMarried() { return isMarried; }
	 * 
	 * public void setIsMarried(String isMarried) { this.isMarried = isMarried; }
	 * 
	 * public String getGovtId() { return govtId; }
	 * 
	 * public void setGovtId(String govtId) { this.govtId = govtId; }
	 * 
	 * public String getGuardianNname() { return guardianNname; }
	 * 
	 * public void setGuardianNname(String guardianNname) { this.guardianNname =
	 * guardianNname; }
	 * 
	 * public long getGuardianContact() { return guardianContact; }
	 * 
	 * public void setGuardianContact(long guardianContact) { this.guardianContact =
	 * guardianContact; }
	 * 
	 * public String getJobLocation() { return jobLocation; }
	 * 
	 * public void setJobLocation(String jobLocation) { this.jobLocation =
	 * jobLocation; }
	 */

}
