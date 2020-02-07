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
@Table(name = "support_request")
public class SupportRequest implements Serializable{

	@EmbeddedId
	private SupportPk supportPk;
	@Column
	private String response;
	@Column
	private Date date;
}
