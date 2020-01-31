package com.bcits.discomproject.beans;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "support_request")
public class SupportRequest implements Serializable{

	@EmbeddedId
	private SupportPk support;
}
