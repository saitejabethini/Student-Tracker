package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
public class TestSql {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		final String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "root";
		String password = "hellohyd";
		
		try {
			System.out.println("Connecting to database: ..." + jdbcUrl);
			
			Connection mycon = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
