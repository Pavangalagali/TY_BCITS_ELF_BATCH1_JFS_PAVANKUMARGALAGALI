package com.bcits.employeemanagementinfo.manytomany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name = "Project_Info")
public class ProjectInfo implements Serializable {
	@Id
	@Column
	private int pid;
	@Column
	private String projrctName;
	@Column
	private String technologies;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String location;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "pid"), inverseJoinColumns = @JoinColumn(name = "empId"))
	private List<PrimaryInfo> list;
}
