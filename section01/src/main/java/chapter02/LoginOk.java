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
		
		String userId = request.getParameter("user-id") != "" ? request.getParameter("user-id") : "ID를 입력해주세요";
		String userPass = request.getParameter("user-pass") != "" ? request.getParameter("user-pass") : "PASSWORD를 입력해주세요";
	
		
		String f = "<html><head><title>응답</title></head><body>";
		out.println(f);
		out.println("<h2>로그인 결과</h2>");
		result = userId.equals(defaultUserId) && userPass.equals(defaultUserPass) ? "성공" : "실패";
		out.println("<p>결과 : " + result + "</p>");
		out.println("<p>아이디 : " + userId + "<p>");
		out.println("<p>비밀번호 : " + userPass + "<p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
