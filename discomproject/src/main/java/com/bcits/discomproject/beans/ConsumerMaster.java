package com.bcits.discomproject.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Consumer_Master")
public class ConsumerMaster implements Serializable{
	@Id
	@Column
	private String rrNumber;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column
	private String eMail;
	@Column(name = "phone_number")
	private Long phoneNumber;
	@Column(name = "consumer_type")
	private String consumerType;
	@Column
	private String region;
	@Column
	private String password;
	@Column(name = "house_no")
	private Integer houseNo;
	@Column
	private String address1;
	@Column
	private String address2;
}
