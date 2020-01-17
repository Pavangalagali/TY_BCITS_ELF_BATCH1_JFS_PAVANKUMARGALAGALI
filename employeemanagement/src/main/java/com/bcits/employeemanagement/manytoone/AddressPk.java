package com.bcits.employeemanagement.manytoone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;
@Data
@Embeddable
public class AddressPk implements Serializable{
	@Column(name="empid")
	private int empId;
	@Column(name="address_type")
	private String addressType;
}
