package com.bcits.discom.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class MonthlyConsumptionPk implements Serializable {
	
	@Column
	private String rrNumber;
	@Column
	private Date date;
}
