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
import java.util.ArrayList;
import java.util.List;

import model.Human;
import model.Output;
import model.DAO_inquiry;

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
			intgender = "0";
		}
		if(intgender.equals("1")) {
			gender = "男性";
		}
		if(intgender.equals("2")) {
			gender = "女性";
		}
		
		
		
//		jDBC Driver's part
		List<Output> output_list = new ArrayList<>();
		output_list = model.DAO_inquiry.SelectAllDB();
		request.setAttribute("output_list",output_list);
		
		model.DAO_inquiry.InsertDB(name, intgender, box);
		
		Human human = new Human(name,gender,box);
		request.setAttribute("human", human);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
		dispatcher.forward(request,response);
		
		
	}
} 