package com.visa.training.jpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="account")
@DiscriminatorValue("SA")
public class SavingAccount extends Account{

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(float balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	
}
