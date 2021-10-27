package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class Inquiries_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		Part part = request.getPart("file");
		String file_name = this.getFileName(part);
		System.out.println(file_name);
		
		
		String name = request.getParameter("user_name");
		String intgender = request.getParameter("gender");
		String box = request.getParameter("form_box");
		
		String gender = null;
		if(intgender.equals("0")) {
			gender = "男性";
		}
		if(intgender.equals("1")) {
			gender = "女性";
		}
		
		Human human = new Human(name,gender,box);
		request.setAttribute("human", human);
		System.out.println(human);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiries.jsp");
		dispatcher.forward(request,response);
		
		
	}
	private String getFileName(Part part) {
		String file_name = null;
		for(String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if(dispotion.trim().startsWith("filename")) {
				file_name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"","").trim();
				file_name = file_name.substring(file_name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return file_name;
	}
}