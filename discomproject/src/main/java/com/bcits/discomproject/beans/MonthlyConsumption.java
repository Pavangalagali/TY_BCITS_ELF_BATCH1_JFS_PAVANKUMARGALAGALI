package com.bcits.discomproject.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Monthly_Consumption")
public class MonthlyConsumption implements Serializable{
	@EmbeddedId
	private MonthlyConsumptionPk consumptionPk;
	@Column
	private Double totalUnits;
	@Column
	private Double bill;
	@Column
	private String status;
	@Column
	private Double previousUnits;
	@Column
	private Date takenOn;
	@Column
	private Double finalUnits;
	
}
