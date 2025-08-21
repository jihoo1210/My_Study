

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hambuger.DatabaseConnection;
import hambuger.Dto_Data_transfer_Object;

/**
 * Servlet implementation class OrderOk
 */
@WebServlet("/OrderOk")
public class OrderOk extends HttpServlet {
       

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("�ܺα� ������: " + request.getParameter("size") + "<br>");
		String[] ingredients = request.getParameterValues("ingredient");
		if(ingredients != null) {
			for(String item : ingredients) {
				out.println("�ܺα� �߰� ���: " + item + "<br>");
			}
		} else {out.println("�ܺα� �߰� ���: ���� ����<br>" );}
		out.println("�ܺα� ����: " + request.getParameter("drink") + "<br>");
		out.println("�ܺα� ��û ����: " + request.getParameter("request") + "<br>");
		out.println("�ܺα� �ֹ� ����: " + request.getParameter("totalPrice") + " �� <br>");
		
		String ingredient = String.join(", " , ingredients);
		
		Dto_Data_transfer_Object dto = new Dto_Data_transfer_Object();
		dto.setSize(request.getParameter("size"));
		dto.setIngredients(ingredient);
		dto.setDrink(request.getParameter("drink"));
		dto.setRequest(request.getParameter("request"));
		dto.setTotal(Integer.parseInt(request.getParameter("totalPrice")));
		
		System.out.println(dto.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
