package com.bcits.discomproject.beans;

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
	private Double amount;
	@Column
	private Date dueDate;
	@Column
	private Double initialUnits;
	@Column
	private Double finalUnits;
	@Column
	private Double UnitsConsumed;
	@Column
	private Date readingsTakenOn;
	
	
}
