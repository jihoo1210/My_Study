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
       
       ServletContext context = this.getServletContext(); // servletContext ��ü ��������
       
       String admin = context.getInitParameter("adminName"); // ServletContext ��ü�κ��� �̸��� admin�� �ʱ�ȭ �Ű����� ��������
       out.println("�ϳ��� ���� : " + admin);
       out.println("<br><br>");
     
       //�ѰŹ��� ����
       Enumeration<String> paramNames = context.getInitParameterNames(); // ServletContext ��ü�κ��� ��� �ʱ�ȭ �Ű����� ��������
       while(paramNames.hasMoreElements()) { // ���� �Ӽ��� ���� ���� �ݺ�
          String name = paramNames.nextElement(); // ���� �Ӽ��� �̸� ��ȯ
          String value = context.getInitParameter(name); // �ش� �̸��� �����ϴ� �� ��ȯ
          out.println(name +" : " + value + "<br>");
       }
       
   }

}
