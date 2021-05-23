package com.capgeminijpa.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.capgeminijpa.model.Employee;

public class EmployeeCriteriaMain 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employee_JPA");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Employee employee1 = new Employee(1001, "emp1", 10000.00, "addr1");
		Employee employee2 = new Employee(1002, "emp2", 20000.00, "addr2");
		Employee employee3 = new Employee(1003, "emp3", 30000.00, "addr3");
		Employee employee4 = new Employee(1004, "emp4", 10000.00, "addr4");
		Employee employee5 = new Employee(1005, "emp5", 20000.00, "addr5");
		Employee employee6 = new Employee(1006, "emp6", 20000.00, "addr6");
		Employee employee7 = new Employee(1007, "emp7", 50000.00, "addr7");
		
		em.persist(employee1);
		em.persist(employee2);
		em.persist(employee3);
		em.persist(employee4);
		em.persist(employee5);
		em.persist(employee6);
		em.persist(employee7);
		
		//select e from Employee e;
		CriteriaBuilder builder1 = em.getCriteriaBuilder();
		CriteriaQuery<Employee> query1 = builder1.createQuery(Employee.class);
		Root<Employee> root1 = query1.from(Employee.class);
		query1.select(root1);
	    TypedQuery<Employee> typedQuery1 = em.createQuery(query1);
		List<Employee> empList1 = typedQuery1.getResultList();
		for (Employee emp : empList1) 
		{
			System.out.println(emp);
		}
		System.out.println("-----------------------------------------------------------------------");
		
		//"select e from Employee as e where e.salary > 20000.00";
		CriteriaBuilder builder2 = em.getCriteriaBuilder();
		CriteriaQuery<Employee> query2 = builder2.createQuery(Employee.class);
		Root<Employee> root2 = query2.from(Employee.class);
		query2.select(root2).where(builder2.gt(root2.get("salary"),20000.00));
		TypedQuery<Employee> typedQuery2 = em.createQuery(query2);
		List<Employee> empList2 = typedQuery2.getResultList();
		for (Employee emp : empList2) 
		{
			 System.out.println(emp);
		}
		System.out.println("-----------------------------------------------------------------------");

		//"select e from Employee as e where e.salary > 20000.00 order by e.salary";
		CriteriaBuilder builder3=em.getCriteriaBuilder();
		CriteriaQuery<Employee> query3=builder3.createQuery(Employee.class);
		Root<Employee> root3=query3.from(Employee.class);
		query3.select(root3).where(builder3.ge(root3.get("salary"),20000.00)).orderBy(builder3.desc(root3.get("salary")));
		TypedQuery<Employee> typedQuery3 = em.createQuery(query3);
		List<Employee> empList3 = typedQuery3.getResultList();
		for (Employee emp : empList3) 
		{
			 System.out.println(emp);
		}
		System.out.println("-----------------------------------------------------------------------");

		//"select e.employeeName from Employee as e ";
		CriteriaBuilder builder4 = em.getCriteriaBuilder();
		CriteriaQuery<String> query4 = builder4.createQuery(String.class);
		Root<Employee> root4 = query4.from(Employee.class);
		query4.select(root4.get("employeeName"));
		TypedQuery<String> typedQuery4 = em.createQuery(query4);
		List<String> names = typedQuery4.getResultList();
		for (String name : names)
		{
			System.out.println(name);
		}
		System.out.println("-----------------------------------------------------------------------");
		
		// "select e.emplyeeId,e.employeeName,e.salary from Employee as e ";
		CriteriaBuilder builder5 = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query5 = builder5.createQuery(Object[].class);
		Root<Employee> root5 = query5.from(Employee.class);
		query5.select(builder5.array(root5.get("employeeId"), root5.get("employeeName"), root5.get("salary")));
		TypedQuery<Object[]> typedQuery5 = em.createQuery(query5);
		List<Object[]> list = typedQuery5.getResultList();
		for (Object[] objArray : list)
		{
			for (int index = 0; index < objArray.length; index++) 
			{
				System.out.print(objArray[index] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------");

		//select distinct e.salary from Employee e 
		CriteriaBuilder builder6=em.getCriteriaBuilder();
		CriteriaQuery<Double> query6=builder6.createQuery(Double.class);
		Root<Employee> root6=query6.from(Employee.class);
		query6.select(root6.get("salary")).distinct(true);
		TypedQuery<Double> typedQuery6=em.createQuery(query6);
		List<Double> list1=typedQuery6.getResultList();
		for(Double emp:list1)
		{
			System.out.println(emp);
		}
		em.getTransaction().commit();
		em.close();
	}
}
