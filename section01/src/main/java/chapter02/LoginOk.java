package chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginok")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		String defaultUserId = "123";
		String defaultUserPass = "123";
		String result = "";
		
		String userId = request.getParameter("user-id") != "" ? request.getParameter("user-id") : "ID�� �Է����ּ���";
		String userPass = request.getParameter("user-pass") != "" ? request.getParameter("user-pass") : "PASSWORD�� �Է����ּ���";
	
		
		String f = "<html><head><title>����</title></head><body>";
		out.println(f);
		out.println("<h2>�α��� ���</h2>");
		result = userId.equals(defaultUserId) && userPass.equals(defaultUserPass) ? "����" : "����";
		out.println("<p>��� : " + result + "</p>");
		out.println("<p>���̵� : " + userId + "<p>");
		out.println("<p>��й�ȣ : " + userPass + "<p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
