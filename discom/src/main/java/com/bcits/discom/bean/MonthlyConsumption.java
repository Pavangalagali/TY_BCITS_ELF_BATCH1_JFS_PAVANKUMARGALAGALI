package com.bcits.discom.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Monthly_Consumption")
public class MonthlyConsumption {
	@EmbeddedId
	private MonthlyConsumptionPk consumptionPk;
	@Column
	private double previousUnits;
	@Column
	private double finalUnits;
	@Column
	private double totalUnits;
	@Column
	private double bill;
	@Column
	private String status;
	
}
