package com.bcits.discom.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Current_Bill")
public class CurrentBill implements Serializable {
	@Id
	@Column
	private String rrNumber;
	@Column
	private double amount;
	@Column
	private Date dueDate;
	@Column
	private double initialUnits;
	@Column
	private double finalUnits;
	@Column
	private double UnitsConsumed;
	@Column
	private Date readingsTakenOn;
	
	
}
