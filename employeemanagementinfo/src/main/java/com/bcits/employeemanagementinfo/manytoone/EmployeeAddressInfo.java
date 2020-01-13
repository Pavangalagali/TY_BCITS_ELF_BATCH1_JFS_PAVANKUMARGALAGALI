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
@Table(name = "Employee_Address_Info")
public class EmployeeAddressInfo implements Serializable {
	@EmbeddedId
	private EmployeeAddressPK adressPk;
	@Column
	private String houseNo;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String landMark;
	@Column
	private String city;
	@Column
	private long pincode;
	
	@MapsId("empId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empId")
	private PrimaryInfo primaryInfo;
}
