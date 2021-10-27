package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

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
		System.out.println(name + intgender + box);
		
		String gender = null;
		if(intgender == null) {
			gender = "ê´ï ïsñæ";
			intgender = "";
		}
		if(intgender.equals("1")) {
			gender = "íjê´";
		}
		if(intgender.equals("2")) {
			gender = "èóê´";
		}
		
		
		Human human = new Human(name,gender,box);
		request.setAttribute("human", human);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
		dispatcher.forward(request,response);
		
		
	}
} 