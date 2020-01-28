package com.bcits.springrestjaxb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;

@Data
@XmlRootElement(name = "User-other-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserOtherInfo implements Serializable {

	@XmlElement
	private String gender;
	@XmlElement
	private Long aadhar;
}