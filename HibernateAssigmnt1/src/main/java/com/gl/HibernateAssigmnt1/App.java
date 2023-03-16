package com.gl.HibernateAssigmnt1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateAssgmnt1.config.HibernateConfig;
import com.gl.HibernateAssgmnt1.entity.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
        Teacher teacher = new Teacher("Amogh","Deshpande","DeshSon@abc.com");
//        List<Teacher> list = getAllTeachers();
//        for(Teacher val : list) {
//        	System.out.println(val);
//        }
//    	Teacher teacher = getTeacherById(3);
//    	System.out.println(teacher);
        teacher.setId(5);
//        System.out.println(insertTeacher(teacher));
        
        deleteTeacher(teacher);
//        System.out.println("Sucessfully deleted");
    }
    
    public static int insertTeacher(Teacher teacher) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(teacher);
    	tx.commit();
    	session.close();
    	return teacher.getId();
    }
    
    public static Teacher updateTeacher(Teacher teacher) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	Teacher updatedTeacher = session.merge(teacher);
    	tx.commit();
    	session.close();
    	return updatedTeacher;
    }
    
    public static void deleteTeacher(Teacher teacher) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(teacher);
    	tx.commit();
    	session.close();
    }
    
    public static Teacher getTeacherById(int id) {
    	Session session = factory.openSession();
    	Teacher teacher = session.get(Teacher.class, id);
    	session.close();
    	return teacher;
    }
    
    public static List<Teacher> getAllTeachers() {
    	Session session = factory.openSession();
    	List<Teacher> list = new ArrayList<>();
    	list = session.createQuery("from Teacher", Teacher.class).getResultList();
    	return list;
    }
}
