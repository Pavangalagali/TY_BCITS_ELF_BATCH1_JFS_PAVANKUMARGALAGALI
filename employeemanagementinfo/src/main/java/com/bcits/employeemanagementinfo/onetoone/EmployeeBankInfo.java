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
@Table(name = "employee_bank_info")
public class EmployeeBankInfo implements Serializable{
	@Id
	private int empId;
	@Column
	private long accountNo;
	@Column
	private String bankName;
	@Column
	private String branchName;
	@Column
	private String ifscCode;
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private PrimaryInfo primary;
	
	/*
	 * public PrimaryInfo getPrimary() { return primary; } public void
	 * setPrimary(PrimaryInfo primary) { this.primary = primary; } public int
	 * getEmpId() { return empId; } public void setEmpId(int empId) { this.empId =
	 * empId; } public long getAccountNo() { return accountNo; } public void
	 * setAccountNo(long accountNo) { this.accountNo = accountNo; } public String
	 * getBankName() { return bankName; } public void setBankName(String bankName) {
	 * this.bankName = bankName; } public String getBranchName() { return
	 * branchName; } public void setBranchName(String branchName) { this.branchName
	 * = branchName; } public String getIfscCode() { return ifscCode; } public void
	 * setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }
	 */
	
}
