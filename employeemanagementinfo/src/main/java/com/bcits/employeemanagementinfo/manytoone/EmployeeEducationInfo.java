package com.bcits.employeemanagementinfo.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="Employee_Education_Info")
public class EmployeeEducationInfo implements Serializable {
	@EmbeddedId
	private EducationPk education;
	@Column
	private String collegeName;
	@Column
	private int yearOfPassout;
	@Column
	private String stream;
	@Column
	private double percentage;
	@Column
	private String university;
	
	@MapsId("empId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private PrimaryInfo primaryInfo;
}
