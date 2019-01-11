package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saiteja.studenttracker.Student;

public class DemoDeleteStudent {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
		
		try {
			int studentId = 6;
			
			
			s = sf.getCurrentSession();
			s.beginTransaction();
			
			System.out.println("Retrieving student with id :" + studentId);
			
			Student readStudent = s.get(Student.class, studentId);
			System.out.println("Deleting student ....");
			
			s.delete(readStudent);
			
			s.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
		}
	}

}
