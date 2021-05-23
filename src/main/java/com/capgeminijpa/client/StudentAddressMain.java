package com.capgeminijpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgeminijpa.model.Address;
import com.capgeminijpa.model.Student;

public class StudentAddressMain 
{
	public static void main(String[] args) {

		Address add1 = new Address("1-2-3", "stree1", "city1", 12345);
		Student s1 = new Student();
		s1.setStudentId(1001);
		s1.setStudentName("stu1");
		s1.setAddress(add1);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(s1);
		
		Student stu = entityManager.find(Student.class, 1001);
		System.out.println(stu);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
