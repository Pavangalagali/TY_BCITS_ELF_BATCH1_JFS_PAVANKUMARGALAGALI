package com.bcits.discomproject.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bill_history")
public class BillHistory implements Serializable{

	@EmbeddedId
	private BillHistoryPk billHistoryPk;
	@Column
	private Double bill;
	@Column
	private String status;
	@Column
	private String region;
	
}
