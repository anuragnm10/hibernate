package com.gl.HibernateAssgmnt2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateAssgmnt2.config.HibernateConfig;
import com.gl.HibernateAssgmnt2.entity.Address;
import com.gl.HibernateAssgmnt2.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	Address address = new Address("10003","Indiana","Ind","USA");
    	Student student = new Student("Amogh","773299163",address);
    	student.setId(6);
    	deleteStudent(student);
//    	System.out.println(insertStudent(student));
    	
//    	address.setPin("10003");
//    	Session sess = factory.openSession();
//    	Transaction tx = sess.beginTransaction();
//    	sess.remove(address);
//    	tx.commit();
//    	sess.close();
    	
    }
    
	private static int insertStudent(Student student) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(student);
    	tx.commit();
    	session.close();
    	return student.getId();
    }
    
    private static void deleteStudent(Student student) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(student);
    	tx.commit();
    	session.close();
    }
}
