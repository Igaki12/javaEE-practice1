package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO_inquiry {
	
	
	public static void DeleteDB(int id) {
		String path ="jdbc:mysql://localhost:3306/inquirydb";
		String user_id ="root";
		String pw ="";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      conn = DriverManager.getConnection(path, user_id, pw);
		      conn.setAutoCommit(false);
			
			String sql = "DELETE FROM inquiry WHERE id=?";
		      ps = conn.prepareStatement(sql);
		      ps.setInt(1, id);
		      System.out.println(ps);
		      int i = ps.executeUpdate();
		      System.out.println("Success_delete:" + i);
		      conn.commit();
		      conn.close();
		      ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public static void UpdateDB(int id,String name,int gender, String contents) {
		String path ="jdbc:mysql://localhost:3306/inquirydb";
		String user_id ="root";
		String pw ="";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      conn = DriverManager.getConnection(path, user_id, pw);
		      conn.setAutoCommit(false);
			
			String sql = "UPDATE inquiry SET name=?, gender=?, contents=? WHERE id=?";
		      ps = conn.prepareStatement(sql);
		      ps.setString(1, name);
		      ps.setInt(2, gender);
		      ps.setString(3, contents);
		      ps.setInt(4, id);
		      int i = ps.executeUpdate();
		      System.out.println("Success_update:" + i);
		      conn.commit();
		      conn.close();
		      ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Output> SelectAllDB() {
		List<Output> output_list = new ArrayList<>(); 
		
		String path ="jdbc:mysql://localhost:3306/inquirydb";
		String user_id ="root";
		String pw ="";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      conn = DriverManager.getConnection(path, user_id, pw);
		      conn.setAutoCommit(false);
			
			String sql = "SELECT * FROM inquiry";
		      ps = conn.prepareStatement(sql);
		      
		      ResultSet rs = ps.executeQuery();
		      String id = null;
		      String name  = null;
		      String gender = null;
		      String contents = null;
		      
		      while(rs.next()) {
		    	  id = rs.getString("id");
			      name = rs.getString("name");
			      gender = rs.getString("gender");
			      contents  = rs.getString("contents");
			      
			      Output output = new Output(id,name,gender,contents);
			      output_list.add(output);
		      }
		      
		      System.out.println("Success_selectAll");
		      conn.close();
		      ps.close();
		      rs.close();
		      
		      return output_list;
		      
		      
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
			return null;
		}
		
	}
	public static void InsertDB(String name,String gender,String contents) {
//		“®ì‚Í‚·‚é‚ªDB‚É’Ç‰Á‚Å‚«‚Ä‚¢‚È‚¢ => conn.commit ‚Å‰ðŒˆ
		String path ="jdbc:mysql://localhost:3306/inquirydb";
		String user_id ="root";
		String pw ="";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      conn = DriverManager.getConnection(path, user_id, pw);
		      conn.setAutoCommit(false);
			
			String sql = "INSERT INTO inquiry(name,gender,contents) VALUES(?,?,?)";
		      ps = conn.prepareStatement(sql);
		      ps.setString(1, name);
		      ps.setString(2, gender);
		      ps.setString(3, contents);
		      System.out.println(ps);
		      int i = ps.executeUpdate();
		      System.out.println("Success_insert:" + i);
		      conn.commit();
		      conn.close();
		      ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static Output SelectDB(String id) {
		String path ="jdbc:mysql://localhost:3306/inquirydb";
		String user_id ="root";
		String pw ="";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		      conn = DriverManager.getConnection(path, user_id, pw);
		      conn.setAutoCommit(false);
			
			String sql = "SELECT * FROM inquiry WHERE id=?";
		      ps = conn.prepareStatement(sql);
		      ps.setInt(1,Integer.parseInt(id));
		      
		      ResultSet rs = ps.executeQuery();
		      rs.next();
		      String name  = null;
		      String gender = null;
		      String contents = null;	      
			  name = rs.getString("name");
			  gender = rs.getString("gender");
			  contents  = rs.getString("contents");
			      
			      Output output = new Output(id,name,gender,contents);

		      System.out.println("Success_selectOne");
		      conn.close();
		      ps.close();
		      rs.close();
		      
		      return output;
		      
		      
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
			return null;
		}
	}
	
}