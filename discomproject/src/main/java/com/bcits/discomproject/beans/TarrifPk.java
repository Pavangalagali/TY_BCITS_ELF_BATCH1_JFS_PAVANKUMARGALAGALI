package com.bcits.discomproject.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TarrifPk implements Serializable {

	@Column
	private String type;
	@Column
	private Long range;
	
}
