package com.capgeminijpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgeminijpa.model.Account;
import com.capgeminijpa.model.CurrentAccount;
import com.capgeminijpa.model.SavingAccount;

public class AccountMain 
{
	public static void main(String[] args) {
		Account acc1 = new Account();
		acc1.setAccountId(1);
		acc1.setAccountName("account1");

		SavingAccount sacc = new SavingAccount();
		sacc.setAccountId(2);
		sacc.setAccountName("accunt2");
		sacc.setMinBalance(10000);

		CurrentAccount cacc = new CurrentAccount();
		cacc.setAccountId(3);
		cacc.setAccountName("accunt3");
		cacc.setCompanyName("company1");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(acc1);
		entityManager.persist(sacc);
		entityManager.persist(cacc);

		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
