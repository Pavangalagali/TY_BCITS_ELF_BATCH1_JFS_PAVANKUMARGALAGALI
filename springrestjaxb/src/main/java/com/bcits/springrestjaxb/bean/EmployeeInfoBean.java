package com.bcits.springrestjaxb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeId","name"})
@XmlRootElement(name = "Employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeInfoBean implements Serializable {

	@JsonProperty("employeeId")
//	@XmlElement(name = "Employee-id")
	@XmlAttribute(name = "Employee-id")  // to make any field as attribute
	private Integer empId;
	@XmlElement
	private String name;
	@XmlElement
	private Long mobileNum;
	@XmlElement
	private String maildId;
	@XmlElement
	private Date birthDate;
	@XmlElement
	private Date joiningDate;
	@XmlElement
	private String designation;
	@XmlElement
	private String bloodGroup;
	@XmlElement
	private Double salary;
	@JsonProperty("departmentId")
	@XmlElement
	private Integer deptId;
	@JsonProperty("managerId")
	@XmlElement
	private Integer mgrId;
//	@XmlTransient // to avoid binding
	@JsonIgnore
	@XmlElement
	private String password;

}