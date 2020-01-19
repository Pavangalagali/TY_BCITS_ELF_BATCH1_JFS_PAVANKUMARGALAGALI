package com.bcits.discom.bean;

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
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String eMail;
	@Column
	private long phoneNumber;
	@Column
	private String consumerType;
	@Column
	private String region;
	@Column
	private String password;
	@Column
	private int houseNo;
	@Column
	private String address1;
	@Column
	private String address2;
}
