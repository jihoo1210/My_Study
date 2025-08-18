package chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySecoundServlet
 */
@WebServlet("/secound") //������̼�: URL mapping @WebServlet(description="asd", urlPattern={"/asd"})
public class MySecoundServlet extends HttpServlet {

	/** servlet ���� �� ó������ �۵��ϴ� �޼���*/
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("run init");
	}

	/** servlet ���� ������ �۵��ϴ� �޼���*/
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("run destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); // ������ html, utf-8 ������ �Ѵ�.
		
		PrintWriter out = response.getWriter();
		
		out.println("<htmi>");
		out.println("<head>");
		out.println("<title>survlet document</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>this is survlet document ����</h1>");
		out.println("</body>");
		out.println("</htmi>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
