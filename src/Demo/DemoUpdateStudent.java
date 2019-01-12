package Demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saiteja.studenttracker.Student;

public class DemoUpdateStudent {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
		
		try {
			int stuId = 6;
			
			s = sf.getCurrentSession();
			
			s.beginTransaction();
			
			System.out.println("Retrieving student with id: " + stuId);
			
			Student rs = s.get(Student.class, stuID);
			System.out.println("Updating student data...");
			
			rs.setFirstName("Saiteja");
			s.getTransaction().commit();
			
			s = sf.getCurrentSession();
			s.beginTransaction();
			
			System.out.println("Updating email for all students");
			
			int rows = s.createQuery("Update Student set email = 'teja_btn@hotmail.com").executeUpdate();
			
			System.out.println("Rows updated:" + rows);
			
			s.getTransaction().commit();
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
		}
	}
}
