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
		description = "서블릿 문서", // 서블릿에 대한 설명
		urlPatterns = "/third",  // URL mapping name setting
		//loadOnStartup = "", // 컨테이너 실행 시 로드되는 서블릿의 순서 지정
		initParams = {@WebInitParam(name="users", value="jihoo")} // 어노테이션을 활용해 파라미터 지정(name="" value="")
		)
public class MyFirstServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("init 메서드 수행");
	};
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
		
		String f = "<html><head><title>응답</title></head><body>";
		out.println(f);
		out.println("<h2>로그인 결과</h2>");
		out.println("</body></html>");
	}
		public void destroy() {
			System.out.println("destroy 메서드 수행");
		};
	
}
