package com.gl.HibernateAssgmnt4;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateAssgmnt4.config.HibernateConfig;
import com.gl.HibernateAssgmnt4.entity.Course;
import com.gl.HibernateAssgmnt4.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {

    	Student s1 = new Student("Pranav","pud@abc.com","47283332");
    	Course c1 = new Course("Data Science","12");
    	Course c2 = new Course("Python","2");
    	Course c3 = new Course("Machine learning","3");
    	List<Course> list = new ArrayList<>();
    	list.add(c1);
    	list.add(c2);
    	list.add(c3);
    	s1.setCourses(list);
    	c1.setStudent(s1);
    	c2.setStudent(s1);
    	c3.setStudent(s1);
    	System.out.println(insertStudent(s1));

    	int Id = 2;
    	Session session = factory.openSession();
    	Course course = session.get(Course.class, Id);
    	
    	Transaction tx = session.beginTransaction();
    	
    	deleteCourse(course);
    	
    	tx.commit();
    	session.close();
    	
    	
        
    }
    
    public static int insertStudent(Student student) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(student);
    	tx.commit();
    	session.close();
    	return student.getId();
    }
    
    public static void deleteStudent(Student student) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(student);
    	tx.commit();
    	session.close();
    }
    
    public static void deleteCourse(Course course) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(course);
    	tx.commit();
    	session.close();
    }
}
