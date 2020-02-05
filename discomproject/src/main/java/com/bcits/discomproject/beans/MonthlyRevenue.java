package com.bcits.discomproject.beans;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MonthlyRevenue implements Serializable{

	private Double estimation;
	
	private Double collected;

	private Date date;
}
