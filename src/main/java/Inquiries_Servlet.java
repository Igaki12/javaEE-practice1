import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InquiriesServlet")

public class Inquiries_Servlet extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
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
		out.println("</body>");
		out.println("</html>");
		
		
	}
}