package com.visa.training.jpa.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.CurrentAccount;
import com.visa.training.jpa.domain.SavingAccount;

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		SavingAccount sa = new SavingAccount(1000);
		CurrentAccount ca = new CurrentAccount(2000, 1000);
		
		em.persist(sa);
		em.persist(ca);
		
		tx.commit();
		
		Account unknownType = em.find(Account.class,sa.getId());
		System.out.println("This account is of type " + unknownType.getClass().getName());
		System.exit(0);
	}

}
