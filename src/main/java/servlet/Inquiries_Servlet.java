package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Human;
import model.Output;
import model.DAO_inquiry;

@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class Inquiries_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		
	    if(request.getParameter("action") == null) {
	    	List<Output> output_list = new ArrayList<>();
			output_list = model.DAO_inquiry.SelectAllDB();
			request.setAttribute("output_list",output_list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
			dispatcher.forward(request, response);
			return;
	    }
		
		String action = request.getParameter("action");
		
		if (action.equals("delete")) {
			String str_id = request.getParameter("object");
			int id = Integer.parseInt(str_id);
			model.DAO_inquiry.DeleteDB(id);
			
			List<Output> output_list = new ArrayList<>();
			output_list = model.DAO_inquiry.SelectAllDB();
			request.setAttribute("output_list",output_list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
			dispatcher.forward(request, response);
		}
		if (action.equals("update")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String str_id = request.getParameter("id");
		String name = request.getParameter("user_name");
		String str_gender = request.getParameter("gender");
		int intgender = 0;
		intgender = Integer.parseInt(str_gender);
		String box = request.getParameter("form_box");
		int id = Integer.parseInt(str_id);
		
//		jDBC Driver's part
		model.DAO_inquiry.UpdateDB(id, name, intgender, box);
		List<Output> output_list = new ArrayList<>();
		output_list = model.DAO_inquiry.SelectAllDB();
		request.setAttribute("output_list",output_list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
		dispatcher.forward(request,response);
		
	}
}