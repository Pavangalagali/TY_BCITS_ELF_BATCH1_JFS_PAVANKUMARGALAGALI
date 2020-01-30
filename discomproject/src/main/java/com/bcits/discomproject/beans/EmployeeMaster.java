package com.bcits.discomproject.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Employee_Master")
public class EmployeeMaster implements Serializable{
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String role;
	@Column
	private String eMail;
	@Column
	private String password;
	@Column
	private String region;
	
}
