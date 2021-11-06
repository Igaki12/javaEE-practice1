import java.sql.*;

public class DBConnect {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inquirydb","root","");
			System.out.println("DBÅ@is connected.");
			return con;
			
		}catch (ClassNotFoundException e) {
			throw new IllegalMonitorStateException();
		}catch (SQLException e) {
			throw new IllegalMonitorStateException();
		}
	}
}
