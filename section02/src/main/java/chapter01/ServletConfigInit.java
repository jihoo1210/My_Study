package chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "파라미터 기본값 지정", 
		urlPatterns = { "/servletconfiginit" }, 
		initParams = { 
				@WebInitParam(name = "userName", value = "parkjihoo"), 
				@WebInitParam(name = "userCompany", value = "jihooCompany")
		})
public class ServletConfigInit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = getInitParameter("userName");
		String f = "<html><head><title>응답</title></head><body>";
		out.println(f);
		out.println("<h2>" + name + "</h2>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
