package com.capgeminijpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgeminijpa.model.Course;
import com.capgeminijpa.model.Trainee;

public class TraineeCourseMain {

	public static void main(String[] args) {
		Trainee trainee1 = new Trainee();
		trainee1.setTraineeName("student1");

		Trainee trainee2 = new Trainee();
		trainee2.setTraineeName("student2");

		Trainee trainee3 = new Trainee();
		trainee3.setTraineeName("student3");

		Course course1 = new Course();
		course1.setCourseName("Java");

		Course course2 = new Course();
		course2.setCourseName("C");

		Course course3 = new Course();
		course3.setCourseName(".Net");

		trainee1.getCourseSet().add(course1);
		trainee1.getCourseSet().add(course2);
		trainee2.getCourseSet().add(course1);
		trainee2.getCourseSet().add(course3);
		trainee3.getCourseSet().add(course1);
		trainee3.getCourseSet().add(course2);
		trainee3.getCourseSet().add(course3);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(trainee1);
		entityManager.persist(trainee2);
		entityManager.persist(trainee3);

		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
