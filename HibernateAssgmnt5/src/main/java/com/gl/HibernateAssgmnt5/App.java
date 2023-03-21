package com.gl.HibernateAssgmnt5;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateAssgmnt5.config.HibernateConfig;
import com.gl.HibernateAssgmnt5.entity.Employee;
import com.gl.HibernateAssgmnt5.entity.Project;

public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
//    	Employee e1 = new Employee();
//    	e1.setName("Satyam");
//    	e1.setEmail("satyam@abc.com");
//    	
//    	Employee e2 = new Employee();
//    	e2.setName("Shivam");
//    	e2.setEmail("shivam@abc.com");
    	
//    	Project p1 = new Project();
//    	p1.setPname("Ed Tech");
//    	Project p2 = new Project();
//    	p2.setPname("Automobile");
    	
    	
    	
//    	List<Employee> list1 = new ArrayList<>();
//    	list1.add(e1);
//    	list1.add(e2);
    	
//    	List<Project> list2 = new ArrayList<>();
//    	list2.add(p1);
//    	list2.add(p2);
    	
//    	e1.setProjects(list2);
//    	e2.setProjects(list2);
//    	p1.setEmployees(list1);
//    	p2.setEmployees(list1);
    	
    	
    	int pid = 1;
    	List<Employee> emps = getAllEmp(pid);
    	for(Employee val : emps) {
    		System.out.println(val);
    	}
    	
    	int eid = 2;
    	List<Project> prj = getAllProjects(eid);
    	for(Project val:prj) {
    		System.out.println(val);
    	}
    	
    }
    public static void insertEmployee(Employee emp)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
			  
		session.persist(emp);
		
		tx.commit();
		session.close();		
	}
    
    public static List<Employee> getAllEmp(int pid){
    	Session session = factory.openSession();
    	Project project = session.get(Project.class, pid);
    	List<Employee> emps = project.getEmployees();
    	session.close();
    	return emps;
    }
    
    public static List<Project> getAllProjects(int Eid){
    	Session session = factory.openSession();
    	Employee employee = session.get(Employee.class, Eid);
    	List<Project> projects = employee.getProjects();
    	session.close();
    	return projects;
    }
}
