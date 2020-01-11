package com.bcits.employeemanagementinfo.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_primary_info")
public class PrimaryInfo implements Serializable {
	@Id
	@Column(name = "empid")
	private int empId;
	@Column
	private String name;
	@Column
	private long mobileNo;
	@Column(name = "official_maildid")
	private String maildId;
	@Column(name = "date_of_birth")
	private Date birthDate;
	@Column(name = "date_of_joining")
	private Date joiningDate;
	@Column
	private String designation;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column
	private double salary;
	@Column(name = "deptid")
	private int deptId;
	@Column(name = "mgrid")
	private int mgrId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMaildId() {
		return maildId;
	}

	public void setMaildId(String maildId) {
		this.maildId = maildId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

}
