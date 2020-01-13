package com.bcits.employeemanagementinfo.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.employeemanagementinfo.manytomany.ProjectInfo;
import com.bcits.employeemanagementinfo.manytoone.EmployeeAddressInfo;
import com.bcits.employeemanagementinfo.manytoone.EmployeeEducationInfo;
import com.bcits.employeemanagementinfo.onetoone.EmployeeBankInfo;
import com.bcits.employeemanagementinfo.onetoone.SecondaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
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
	@Column
	private String maildId;
	@Column
	private Date birthDate;
	@Column
	private Date joiningDate;
	@Column
	private String designation;
	@Column
	private String bloodGroup;
	@Column
	private double salary;
	@Column
	private int deptId;
	@Column
	private int mgrId;
	
	@Exclude
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primaryInfo") //bidirectional
	private SecondaryInfo secondaryInfo;

	@Exclude
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary")
	private EmployeeBankInfo bankInfo;
	
	@Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
	private List<EmployeeAddressInfo> address;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "list")
	private List<ProjectInfo> project;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "primaryInfo")
	private List<EmployeeEducationInfo>  educationInfo;
	/*
	 * public EmployeeBankInfo getBankInfo() { return bankInfo; }
	 * 
	 * public void setBankInfo(EmployeeBankInfo bankInfo) { this.bankInfo =
	 * bankInfo; }
	 * 
	 * public SecondaryInfo getSecondaryInfo() { return secondaryInfo; }
	 * 
	 * public void setSecondaryInfo(SecondaryInfo secondaryInfo) {
	 * this.secondaryInfo = secondaryInfo; }
	 * 
	 * public int getEmpId() { return empId; }
	 * 
	 * public void setEmpId(int empId) { this.empId = empId; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public long getMobileNo() { return mobileNo; }
	 * 
	 * public void setMobileNo(long mobileNo) { this.mobileNo = mobileNo; }
	 * 
	 * public String getMaildId() { return maildId; }
	 * 
	 * public void setMaildId(String maildId) { this.maildId = maildId; }
	 * 
	 * public Date getBirthDate() { return birthDate; }
	 * 
	 * public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
	 * 
	 * public Date getJoiningDate() { return joiningDate; }
	 * 
	 * public void setJoiningDate(Date joiningDate) { this.joiningDate =
	 * joiningDate; }
	 * 
	 * public String getDesignation() { return designation; }
	 * 
	 * public void setDesignation(String designation) { this.designation =
	 * designation; }
	 * 
	 * public String getBloodGroup() { return bloodGroup; }
	 * 
	 * public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup;
	 * }
	 * 
	 * public double getSalary() { return salary; }
	 * 
	 * public void setSalary(double salary) { this.salary = salary; }
	 * 
	 * public int getDeptId() { return deptId; }
	 * 
	 * public void setDeptId(int deptId) { this.deptId = deptId; }
	 * 
	 * public int getMgrId() { return mgrId; }
	 * 
	 * public void setMgrId(int mgrId) { this.mgrId = mgrId; }
	 */

}
