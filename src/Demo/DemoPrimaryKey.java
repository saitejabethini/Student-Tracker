package Demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saiteja.studenttracker.Student;

public class DemoPrimaryKey {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
		
		try {
			
			System.out.println("Creating 3 student objects");
			
			Student s1 = new Student("Phani", "Mullapudi","mks@gmail.com");
			Student s2 = new Student("Sindhu","Kotapati","sindhuk@gmail.com");
			Student s3 = new Student("Sai","Bethini","tejabtn@outlook.com");
			
			s.beginTransaction();
			
			s.save(s1);
			s.save(s2);
			s.save(s3);
			System.out.println("Java objects saved to the database");
			
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
