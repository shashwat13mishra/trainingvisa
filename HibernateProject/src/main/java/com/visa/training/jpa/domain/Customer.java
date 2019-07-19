package com.visa.training.jpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String firstname;
	String middlename;
	String lastname;
	java.sql.Date dateofjoin;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)//maps account owner of the association
	//@OneToMany
	//@JoinColumn(name = "cust_id")
	List<Account> accounts = new ArrayList<Account>();

	@ManyToMany(cascade = CascadeType.PERSIST) // Yh ho to address apne aap add ho jaaye
	@JoinTable(name = "customer_address", joinColumns = @JoinColumn(name = "cust_id"),inverseJoinColumns = @JoinColumn(name = "address_id"))
	List<Address> addresses =new ArrayList<Address>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getMiddlename() {
		return middlename;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer(String firstname,String middlename, String lastname, Date dateofjoin) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoin = dateofjoin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public java.sql.Date getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(java.sql.Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	
}