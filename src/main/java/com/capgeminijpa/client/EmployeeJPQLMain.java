package com.capgeminijpa.client;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgeminijpa.model.Employee;

public class EmployeeJPQLMain
{
	public static void main(String[] args) 
	{
		Employee employee1 = new Employee(1001, "emp1", 10000.00, "addr1");
		Employee employee2 = new Employee(1002, "emp2", 20000.00, "addr2");
		Employee employee3 = new Employee(1003, "emp3", 30000.00, "addr3");
		Employee employee4 = new Employee(1004, "emp4", 10000.00, "addr4");
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
		//performing Query operations
		//Query query=em.createQuery("from Employee");
		Query query1 = em.createQuery("select e from Employee as e");
		List<Employee> empList1=query1.getResultList();
		for(Employee emp:empList1)
		{
			System.out.println(emp);
		}
		System.out.println("---------------------------------------------------------------------------------------");
		Query query2 = em.createQuery("select e from Employee as e where e.salary>=20000");
		List<Employee> empList2=query2.getResultList();
		for(Employee emp:empList2)
		{
			System.out.println(emp);
		}
		System.out.println("---------------------------------------------------------------------------------------");
		Query query3 = em.createQuery("select e from Employee as e order by salary desc");
		Stream stream1 = query3.getResultStream();
		stream1.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------------------");
		Query query4 = em.createQuery("select e from Employee as e where e.salary >= 15000.00 order by salary desc");
	    Stream stream2 = query4.getResultStream();
		stream2.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------------------");
		Query query5 = em.createQuery("select e.employeeName from Employee as e");
		List<String> nameList = query5.getResultList();
		Stream stream3 = query5.getResultStream();
		stream3.forEach(System.out::println);
		for (String name : nameList) 
		{
			System.out.println(name);
		}
		System.out.println("---------------------------------------------------------------------------------------");
		Query query6 =em.createQuery("select e.employeeName,e.salary from Employee as e" );
		List<Object[]> list = query6.getResultList();
		for (Object[] objArray : list)
		{ 
			for (int index = 0; index < objArray.length;index++) 
			{ 
				System.out.print(objArray[index] + "     "); 
			}
			System.out.println(); 
		}
		System.out.println("---------------------------------------------------------------------------------------");
		Query query7 = em.createQuery("select max(salary),min(salary),avg(salary),count(*) from Employee as e");
		List<Object[]> list1 = query7.getResultList();
		for (Object[] objArray : list1)
		{
			for (int index = 0; index < objArray.length; index++) 
			{
				 System.out.print(objArray[index] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------------------");
		Query query8 = em.createQuery("select e from Employee as e");
		query8.setFirstResult(3);
		query8.setMaxResults(3);
	    List<Employee> empList = query8.getResultList();
		for (Employee emp : empList) 
		{
			System.out.println(emp);
		}
		System.out.println("---------------------------------------------------------------------------------------");
//		Query query9 = em.createQuery("select e from Employee as e where e.salary > ?1 and e.employeeId > ?2");
//		query9.setParameter(1, new Scanner(System.in).nextDouble());
//		query9.setParameter(2, new Scanner(System.in).nextInt());
//		Stream stream4 = query9.getResultStream();
//		stream4.forEach(System.out::println);
//		System.out.println("---------------------------------------------------------------------------------------");
//		Query query10 = em.createQuery("select e from Employee as e where e.salary > :sal and e.employeeId > :id"); 
//		query10.setParameter("sal", new Scanner(System.in).nextDouble());
//		query10.setParameter("id", new Scanner(System.in).nextInt());
//		Stream stream5 = query10.getResultStream(); 
//		stream5.forEach(System.out::println);
//		System.out.println("---------------------------------------------------------------------------------------");
		TypedQuery<Employee> typedQuery = em.createQuery("from Employee", Employee.class);
//		Employee e=typedQuery.getSingleResult();
		List<Employee> list2 = typedQuery.getResultList();
		list2.forEach(System.out::println);
		em.getTransaction().commit();
		em.close();
	}
}
