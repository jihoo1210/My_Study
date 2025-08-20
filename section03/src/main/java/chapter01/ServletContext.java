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
		
		out.println("���� ������ ������ ���� : " + context.getMajorVersion() + "<br>");
		out.println("���� ������ ���̳� ���� : " + context.getMinorVersion() + "<br>");
		out.println("���� ������ �����̳� �̸��� ���� ���� : " + context.getServerInfo() + "<br>");
		out.println("���� ������ ��� : " + context.getContextPath() + "<br>");
		out.println("���� ������ ���ø����̼� �̸� : " + context.getServletContextName() + "<br>");
		out.println("���ڷ� ������ path�� ���� ��� : " + context.getRealPath("/") + "<br>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
