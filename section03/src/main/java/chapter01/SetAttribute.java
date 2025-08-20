 package chapter01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetAttribute
 */
@WebServlet("/setattr")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetAttribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		ServletContext context = getServletContext();
		
		List person = new ArrayList();
		person.add("jihoo");
		person.add("mikasa");
		
		context.setAttribute("person", person);
		context.setAttribute("city", "gimpo");
		
		PrintWriter out = response.getWriter();
		out.println("<a href='./gatr'>이동하기</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
