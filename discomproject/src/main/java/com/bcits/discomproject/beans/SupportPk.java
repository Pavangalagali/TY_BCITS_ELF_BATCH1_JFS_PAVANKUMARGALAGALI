package com.bcits.discomproject.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class SupportPk implements Serializable {

	@Column
	private String rrNumber;
	@Column
	private String support;
	
	public SupportPk() {}

	public SupportPk(String rrNumber, String support) {
		super();
		this.rrNumber = rrNumber;
		this.support = support;
	}

}
