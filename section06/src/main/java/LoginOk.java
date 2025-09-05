

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/lo")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/jsp; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("age");
		int age = 0;
		
		age = Integer.parseInt(userAge);		
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setAge(age);
		
		// 이미 존재한다면 사용하고, 없다면 새로 만들어라
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		session.setAttribute("userName", userName);
		session.setAttribute("age", age);
		
		response.sendRedirect(request.getContextPath() + "/sample05.jsp");
		// /현재 프로젝트 주소 + /sample05.jsp
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
