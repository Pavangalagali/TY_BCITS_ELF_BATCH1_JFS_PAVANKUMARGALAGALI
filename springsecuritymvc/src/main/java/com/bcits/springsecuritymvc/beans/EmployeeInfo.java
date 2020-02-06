package com.bcits.springsecuritymvc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
public class EmployeeInfo {
	@Id
	@Column(name = "emp_id")
	private Integer empId;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String name;;
	
}
