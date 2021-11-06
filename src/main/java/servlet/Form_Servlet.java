package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Human;
import model.Output;

public class Form_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/form.jsp");
		dispatcher.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user_name");
		String intgender = request.getParameter("gender");
		String box = request.getParameter("form_box");
		
		String gender = null;
		if(intgender == null) {
			gender = "性別不明";
			intgender = "";
		}
		if(intgender.equals("1")) {
			gender = "男性";
		}
		if(intgender.equals("2")) {
			gender = "女性";
		}
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
//		ここからJDBC Driver
		String path ="jdbc:mysql://localhost:3306/inquirydb";
		String id ="root";
		String pw ="";
		
		
		
		String msg = "";
		try {
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      System.out.println("成功");
		      conn = DriverManager.getConnection(path, id, pw);
		      conn.setAutoCommit(false);
		      
		      
		      String sql = "SELECT id,name,gender,contents FROM inquiry";
		      ps = conn.prepareStatement(sql);
		      ResultSet rs = ps.executeQuery();
		      
		      String pNumber = null;
	          String pName = null;
	          String pGender = null;
		      String pContents = null;
		      while (rs.next()){
		      	  pNumber = rs.getString("id");
		          pName = rs.getString("name");
		          String pIntgender = rs.getString("gender");
		          pContents = rs.getString("contents");
		        	
		          pGender = "性別不明";
		          if (pIntgender == "1") {
		        		pGender = "男性";
		          }if (pIntgender == "2") {
		        		pGender = "女性";
		          }
		        	
		        	
		      }
		      Output out = new Output(pNumber,pName,pGender,pContents);
		      request.setAttribute("Output", out);
		        
		        
		      
		      
		      sql ="INSERT INTO inquiry (name,gender,contents) values(?,?,?)";
		      ps = conn.prepareStatement(sql);
		      ps.setString(1, name);
		      ps.setString(2, intgender);
		      ps.setString(3, box);
		      int i = ps.executeUpdate();
		      System.out.println("result:" + i);
		      conn.commit();
		      
		      
		      
		      
        }catch (ClassNotFoundException ex){
		    msg = "失敗a";
		}catch (Exception ex){
		    System.out.println(ex.getMessage());
		    msg = "失敗b";
		}
		System.out.println(msg);
		
		
		Human human = new Human(name,gender,box);
		request.setAttribute("human", human);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
		dispatcher.forward(request,response);
		
		
	}
} 