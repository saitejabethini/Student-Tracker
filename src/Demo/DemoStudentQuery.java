package Demo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saiteja.studenttracker.Student;

@SuppressWarnings("unchecked")
public class DemoStudentQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
 
		try {
			s.beginTransaction();

			List<Student> stud = s.createQuery("from student").getResultList();


			stud = s.createQuery("from Students s where s.lastName = `Smith`").getResultList();

			System.out.println("\n\nDisplay students with last name: smith");
			for(Student student : stud) {
				System.out.println(student);
			}
			
			stud = s.createQuery("from Student s where s.lastName = `bethini` or s.firstName = `kotapati`").getResultList();
			System.out.println("\n\nDisplay students with last name: bethini or firstname: kotapati");
			for(Student student : stud) {
				System.out.println(student);
			}
			
			stud = s.createQuery("from Student s where s.email LIKE '%gmail.com' ").getResultList();
			System.out.println("\n\nDisplay students with email: gmail");
			for(Student student : stud) {
				System.out.println(student);
			}
					
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
