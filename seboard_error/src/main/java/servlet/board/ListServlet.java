package servlet.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seboard.dao.BoardDao;
import seboard.dto.BoardDto;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BoardDao dao = new BoardDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BoardDto> list = dao.findAll();
			int total = dao.bbsCount();
			request.setAttribute("total", total);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			// 내부적으로 페이지 이동 (request.setAttribute)
			// redirect(): 페이지 전체 이동 (HttpSession session.setAttribute)
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
