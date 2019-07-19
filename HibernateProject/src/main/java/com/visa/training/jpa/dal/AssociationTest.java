package com.visa.training.jpa.dal;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.Address;
import com.visa.training.jpa.domain.Customer;
import com.visa.training.jpa.domain.SavingAccount;

public class AssociationTest {

	public static void main(String[] args) {
		// createAccountAndCustomerSeperatley();
		// readAccountAlongWithCustomer();
		// createAccountAndCustomerTogether();
		testLazy();
		testManyToMany();
		System.exit(0);
	}

	private static void testManyToMany() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Customer c = new Customer("ffn", "mmn", "lln", new Date(System.currentTimeMillis()));
		Address a = new Address("sl1", "sl2", "blr", "ka", "56", "in");
		c.getAddresses().add(a);

		em.persist(c);

		tx.commit();
		em.close();

	}

	private static void testLazy() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Customer c1 = em.find(Customer.class, 39);
		em.close();
		System.out.println(c1.getFirstname());
		Account a = c1.getAccounts().get(0);
		System.out.println(a.getBalance());
	}

	private static void createAccountAndCustomerTogether() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Customer c = new Customer("fn", "mn", "ln", new Date(System.currentTimeMillis()));
		SavingAccount sa = new SavingAccount(1234);

		sa.setCustomer(c);
		// em.persist(c);
		em.persist(sa);
		tx.commit();
		em.close();

	}

	private static void readAccountAlongWithCustomer() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		SavingAccount sa = em.find(SavingAccount.class, 32);
		System.out.println(sa.getCustomer().getFirstname());
	}

	private static void createAccountAndCustomerSeperatley() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Customer c = new Customer("fn", "mn", "ln", new Date(System.currentTimeMillis()));
		SavingAccount sa = new SavingAccount(1234);

		sa.setCustomer(c);
		em.persist(c);
		em.persist(sa);
		tx.commit();
		em.close();
	}

}
