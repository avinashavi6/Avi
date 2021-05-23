package com.capgeminijpa.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgeminijpa.model.Passport;
import com.capgeminijpa.model.Person;

public class PersonPassportOneToOneMain 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Person person1 = new Person(101, "per1", 1234, new Date());
		Person person2 = new Person(102, "per2", 1234343, new Date());
		
		Passport passport1 = new Passport(1001, new Date(), "loc1");
		Passport passport2 = new Passport(1002, new Date(), "loc2");
		
		passport1.setPerson(person1);
		passport2.setPerson(person2);
		
		person1.setPassport(passport1);
		person1.setPassport(passport2);
		
		em.persist(person1);
		em.persist(person2);
		
		em.persist(passport1);
		em.persist(passport2);
		
		Person person = em.find(Person.class, 102);
		System.out.println(person.getPassport());
		
		//em.remove(person);
		em.getTransaction().commit();
		em.close();
		
	}
}
