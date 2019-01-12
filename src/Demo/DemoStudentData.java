package Demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saiteja.studenttracker.Student;

public class DemoStudentData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
 
		try {
			
			System.out.println("Creating a new Student object...");
			
			Student st = new Student("Satya","Bethini","bsn@gmail.com");
			
			s.beginTransaction();
			
			s.save(st);
			
			System.out.println("Java object is saved to the database");
			
			s.getTransaction().commit();
			
			System.out.println("Saved student. Id generated in Mysql Database:" + st.getId());
			
			s = sf.getCurrentSession();
			s.beginTransaction();
			
			System.out.println("Getting the student based on id:" + st.getId());
			
			Student readstud = s.get(Student.class, st.getId());
			
			System.out.println("retrieved student:"+ readstud);
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
