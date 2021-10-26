import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/InquiriesServlet")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class Inquiries_Servlet extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		Part part = request.getPart("file");
		String file_name = this.getFileName(part);
		System.out.println(file_name);
		
		
		String name = request.getParameter("user_name");
		String gender = request.getParameter("gender");
		String box = request.getParameter("form_box");
		
		String msg = name + "," + gender + "," + box + "are registered.";
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("<img src=");
		out.println("</body>");
		out.println("</html>");
		
		
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