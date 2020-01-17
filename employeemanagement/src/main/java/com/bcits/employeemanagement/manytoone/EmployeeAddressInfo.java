package com.bcits.employeemanagement.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

import lombok.Data;

@Data
@Entity
@Table(name ="employee_address_info")
public class EmployeeAddressInfo implements Serializable {
	@EmbeddedId
	private AddressPk address;
	@Column(name="house_no")
	private int houseNo;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String landmark;
	@Column
	private long pincode;
	@MapsId("empId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empId")
	private PrimaryInfo primaryInfo;
}
