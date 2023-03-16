package com.gl.HibernateAssgmnt3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateAssgmnt3.config.HibernateConfig;
import com.gl.HibernateAssgmnt3.entity.Address;
import com.gl.HibernateAssgmnt3.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	Session session = factory.openSession();
    	Address address = session.get(Address.class, "1001");
        session.close();
        Session session1 = factory.openSession();
        Student student = session1.get(Student.class, "2");
        System.out.println(student.getAddress().getCity());
        System.out.println(student.getAddress().getCountry());
        System.out.println(address.getStudent().getName());
        System.out.println(address.getStudent().getClass());
    	
//    	Address address = new Address("1001","Mysore","Karnataka","India");
//    	Student student = new Student("Pranav","883666773",address);
//    	System.out.println(insertStudent(student));
        
        
    }
    
    private static int insertStudent(Student student) {
    	System.out.println(insertAddress(student.getAddress()));
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(student);
    	tx.commit();
    	session.close();
    	return student.getId();
    }
    
    private static String insertAddress(Address address) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(address);
    	tx.commit();
    	session.close();
    	return address.getPin();
    }
    
    private static void deleteStudent(Student student) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(student);
    	tx.commit();
    	session.close();
    }
}
