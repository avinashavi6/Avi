package com.capgeminijpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgeminijpa.model.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		Employee employee1 = new Employee(1001, "emp1", 10000.00, "addr1");
		Employee employee2 = new Employee(1002, "emp2", 20000.00, "addr2");
		Employee employee3 = new Employee(1003, "emp3", 30000.00, "addr3");
		Employee employee4 = new Employee(1004, "employee4", 10000.00, "address5");
		Employee employee5 = new Employee(1005, "emp5", 20000.00, "addr5");
		Employee employee6 = new Employee(1006, "emp6", 20000.00, "addr6");
		Employee employee7 = new Employee(1007, "emp7", 50000.00, "addr7");

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee1);
		em.persist(employee2);
		em.persist(employee3);
		em.persist(employee4);
		em.persist(employee5);
		em.persist(employee6);
		em.persist(employee7);
		Employee emp = em.find(Employee.class, 1007); // eager loading
		System.out.println(emp.getEmployeeName());
		Employee emp1 = em.find(Employee.class, 1001); // eager loading
		System.out.println(emp1);
		Employee emp2 = em.find(Employee.class, 1002); // eager loading
		System.out.println(emp2);
		em.getTransaction().commit();
		em.close();
	}
}
