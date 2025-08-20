package chapter01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormExam
 */
@WebServlet("/formOk")
public class FormExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// Parameter: 프로그램 실행 시 동적으로 전달되는 설정 값.
		out.print("번호: " + Integer.parseInt(request.getParameter("num")) + "<br>");
		out.print("이름: " + request.getParameter("name").toString() + "<br>");
		out.print("학점: " + Double.parseDouble(request.getParameter("score")) + "<br>");
		
		Enumeration<String> param = request.getParameterNames();
		while(param.hasMoreElements()) {
			String eName = param.nextElement();
			String eValue = request.getParameter(eName);
			out.print(eName + ": " + eValue + "<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
