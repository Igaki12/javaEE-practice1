package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Output;

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
			return;
		}
		if (action.equals("update")) {
			String id = request.getParameter("object");
			Output pre_update = model.DAO_inquiry.SelectDB(id);
			System.out.println(pre_update.getId() + "," + pre_update.getName() + "," + pre_update.getGender() + "," + pre_update.getContents() );
		    request.setAttribute("pre_update",pre_update);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		????????????update
		String str_id = request.getParameter("id");
		String name = request.getParameter("user_name");
		String str_gender = request.getParameter("gender");
		int intgender = 0;
		intgender = Integer.parseInt(str_gender);
		String box = request.getParameter("form_box");
		int id = Integer.parseInt(str_id);
		
		model.DAO_inquiry.UpdateDB(id, name, intgender, box);
		List<Output> output_list = new ArrayList<>();
		output_list = model.DAO_inquiry.SelectAllDB();
		request.setAttribute("output_list",output_list);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
		dispatcher.forward(request,response);
		
	}
}