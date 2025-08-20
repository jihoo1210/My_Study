package chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext
 */
@WebServlet("/ServletContext")
public class ServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		javax.servlet.ServletContext context = this.getServletContext();
		
		out.println("현재 서블릿의 메이저 버전 : " + context.getMajorVersion() + "<br>");
		out.println("현재 서블릿의 마이너 버전 : " + context.getMinorVersion() + "<br>");
		out.println("현재 서블릿의 컨테이너 이름과 버전 정보 : " + context.getServerInfo() + "<br>");
		out.println("현재 서블릿의 경로 : " + context.getContextPath() + "<br>");
		out.println("현재 서블릿의 에플리케이션 이름 : " + context.getServletContextName() + "<br>");
		out.println("인자로 지정된 path의 실제 경로 : " + context.getRealPath("/") + "<br>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
