package chapter01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ServletContextParam extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html; charset=utf-8");
       PrintWriter out = response.getWriter();
       
       ServletContext context = this.getServletContext(); // servletContext 객체 가져오기
       
       String admin = context.getInitParameter("adminName"); // ServletContext 객체로부터 이름이 admin인 초기화 매개변수 가져오기
       out.println("하나씩 추출 : " + admin);
       out.println("<br><br>");
     
       //한거번에 추출
       Enumeration<String> paramNames = context.getInitParameterNames(); // ServletContext 객체로부터 모든 초기화 매개변수 가져오기
       while(paramNames.hasMoreElements()) { // 다음 속성을 가질 동안 반복
          String name = paramNames.nextElement(); // 다음 속성의 이름 반환
          String value = context.getInitParameter(name); // 해당 이름에 대응하는 값 반환
          out.println(name +" : " + value + "<br>");
       }
       
   }

}
