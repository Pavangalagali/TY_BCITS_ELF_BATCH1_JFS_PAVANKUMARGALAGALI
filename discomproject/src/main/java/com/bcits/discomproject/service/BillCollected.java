package com.bcits.discomproject.service;

import java.util.Date;

import lombok.Data;

@Data
public class BillCollected {

	private Double estimation;
	
	private Double collected;
	
	private Date date;
}
