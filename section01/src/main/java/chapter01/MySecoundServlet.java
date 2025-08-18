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
@WebServlet("/secound") //어노테이션: URL mapping @WebServlet(description="asd", urlPattern={"/asd"})
public class MySecoundServlet extends HttpServlet {

	/** servlet 실행 시 처음으로 작동하는 메서드*/
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("run init");
	}

	/** servlet 제거 직전에 작동하는 메서드*/
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("run destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); // 응답을 html, utf-8 문서로 한다.
		
		PrintWriter out = response.getWriter();
		
		out.println("<htmi>");
		out.println("<head>");
		out.println("<title>survlet document</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>this is survlet document 나는</h1>");
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
