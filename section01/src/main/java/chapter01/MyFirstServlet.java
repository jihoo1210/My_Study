package chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "���� ����", // ������ ���� ����
		urlPatterns = "/third",  // URL mapping name setting
		//loadOnStartup = "", // �����̳� ���� �� �ε�Ǵ� ������ ���� ����
		initParams = {@WebInitParam(name="users", value="jihoo")} // ������̼��� Ȱ���� �Ķ���� ����(name="" value="")
		)
public class MyFirstServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("init �޼��� ����");
	};
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
		
		String f = "<html><head><title>����</title></head><body>";
		out.println(f);
		out.println("<h2>�α��� ���</h2>");
		out.println("</body></html>");
	}
		public void destroy() {
			System.out.println("destroy �޼��� ����");
		};
	
}
