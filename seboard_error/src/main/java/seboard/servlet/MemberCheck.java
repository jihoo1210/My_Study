package seboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seboard.dao.MemberDao;

@WebServlet("/member/check")
public class MemberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String field = request.getParameter("field");
		String value = request.getParameter("value");
		String val = value == null ? "" : value.trim();
		boolean exits = false;
		
		try {
			MemberDao dao = new MemberDao();
			switch(field) {
			   case "userid":
				  exits = dao.existsByUserid(val);
			   break;
			   case "email":
				  exits = dao.existsByEmail(val);
			   break;
			   case "tel":
				  exits = dao.existsByTel(val);
			   break;
			}
			
			String rs = exits ? "1" : "0";
			response.getWriter().write(rs);
			
		}catch(Exception e) {}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
