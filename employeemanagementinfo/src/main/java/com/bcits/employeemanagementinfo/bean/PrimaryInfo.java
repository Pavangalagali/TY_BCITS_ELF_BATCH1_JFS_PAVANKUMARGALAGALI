package com.bcits.employeemanagementinfo.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_primary_info")
public class PrimaryInfo implements Serializable{
	@Id
	@Column
	private int empid;
	@Column
	private String name;
	@Column
	private long mobileNo;
	@Column
	private String official_maildid;
	@Column
	private Date date_of_birth;
	@Column
	private Date date_of_joining;
	@Column
	private String designation;
	@Column
	private String blood_group;
	@Column
	private double salary;
	@Column
	private int deptid;
	@Column
	private int mgrid;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileNo;
	}
	public void setMobileno(long mobileno) {
		this.mobileNo = mobileno;
	}
	public String getOfficial_maildid() {
		return official_maildid;
	}
	public void setOfficial_maildid(String official_maildid) {
		this.official_maildid = official_maildid;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public Date getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getMgrid() {
		return mgrid;
	}
	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}
	
	
	
}
