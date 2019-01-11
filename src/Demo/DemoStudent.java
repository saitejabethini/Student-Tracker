package Demo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saiteja.studenttracker.Student;


public class DemoStudent {
	public static void main(String[] args) {


		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
		
		try {
			System.out.println("Creating a new student object ...");
			
			Student st = new Student("Saiteja", "Bethini", "teja_btn@hotmail.com");
			
			s.beginTransaction();
			
			s.save(st);
			
			System.out.println("Java object saved to the database");
			
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
