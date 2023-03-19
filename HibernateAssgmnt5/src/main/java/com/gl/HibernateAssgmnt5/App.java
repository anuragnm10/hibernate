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

    	Employee e1 = new Employee("Anurag","anm@abc.com");
    	Employee e2 = new Employee("Pranav","pud@abc.com");
    	
    	Project p1 = new Project("Telecom");
    	Project p2 = new Project("Automobile");
    	
    	List<Project> projects = new ArrayList<>();
    	projects.add(p1);
    	projects.add(p2);
    	List<Employee> employees = new ArrayList<>();
    	employees.add(e1);
    	employees.add(e2);
    	
    	e1.setPList(projects);
    	e2.setPList(projects);
    	p1.setEmpList(employees);
    	p2.setEmpList(employees);
    	
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	session.persist(e1);
    	session.persist(e2);
    	session.persist(p1);
    	session.persist(p2);
    	tx.commit();
    	session.close();
    	
    	
    }
}
