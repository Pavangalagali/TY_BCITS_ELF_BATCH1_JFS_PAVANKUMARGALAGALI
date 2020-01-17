package com.bcits.empwebapp.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_primary_info")
public class PrimaryInfo implements Serializable {
	@Id
	@Column(name = "emp_id")
	private int empId;
	@Column
	private String name;
	@Column(name = "mobile")
	private long mobileNum;
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
	@Column(name = "dept_id")
	private int deptId;
	@Column(name = "mgr_id")
	private int mgrId;
	@Column
	private String password;

}
