package com.visa.training.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="account")
@DiscriminatorValue("CA")
public class CurrentAccount extends Account{
	@Column(name="OD_limit")
	float ODLimit;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(float balance, float ODLimit) {
		super(balance);
		this.ODLimit = ODLimit;
	}

	public float getODLimit() {
		return ODLimit;
	}

	public void setODLimit(float oDLimit) {
		ODLimit = oDLimit;
	}
	
	
}
