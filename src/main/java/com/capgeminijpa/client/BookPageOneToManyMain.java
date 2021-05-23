package com.capgeminijpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgeminijpa.model.Book;
import com.capgeminijpa.model.Page;

public class BookPageOneToManyMain {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Book book=new Book();
		book.setBookNo(1);
		book.setBookName("java");
		book.setBookCost(100.0);
		Page p1=new Page();
		p1.setPageNo(1);
		p1.setPageName("firstpage");
		p1.setPageContent("introduction to java");
		Page p2=new Page();
		p2.setPageNo(2);
		p2.setPageName("secondpage");
		p2.setPageContent("datatypes in java");
		p1.setBook(book);
		p2.setBook(book);
		
		em.persist(book);
		em.persist(p1);
		em.persist(p2);
		
		em.getTransaction().commit();
		em.close();
	}
}
