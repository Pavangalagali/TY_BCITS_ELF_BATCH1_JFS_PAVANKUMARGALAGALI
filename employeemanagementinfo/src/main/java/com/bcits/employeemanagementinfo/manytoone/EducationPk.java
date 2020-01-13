package com.bcits.employeemanagementinfo.manytoone;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EducationPk implements Serializable{
	private int empId;
	private String educationType;
}
