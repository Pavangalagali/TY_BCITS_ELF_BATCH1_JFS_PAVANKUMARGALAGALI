package com.bcits.discomproject.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BillHistoryPk implements Serializable{

	@Column
	private String rrNumber;
	@Column Date date;
	
}
