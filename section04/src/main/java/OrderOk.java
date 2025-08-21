

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
		out.println("햄부기 사이즈: " + request.getParameter("size") + "<br>");
		String[] ingredients = request.getParameterValues("ingredient");
		if(ingredients != null) {
			for(String item : ingredients) {
				out.println("햄부기 추가 재료: " + item + "<br>");
			}
		} else {out.println("햄부기 추가 재료: 선택 안함<br>" );}
		out.println("햄부기 음료: " + request.getParameter("drink") + "<br>");
		out.println("햄부기 요청 사항: " + request.getParameter("request") + "<br>");
		out.println("햄부기 주문 가격: " + request.getParameter("totalPrice") + " 원 <br>");
		
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
