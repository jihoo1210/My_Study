package servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seboard.dao.BoardDao;
import seboard.dto.BoardDto;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private final BoardDao dao = new BoardDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String pass = request.getParameter("pass");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDto  dto = new BoardDto();
		dto.setWriter(writer);
		dto.setPass(pass);
		dto.setTitle(title);
		dto.setContent(content);
		try {
			  dao.insert(dto);
			  response.sendRedirect(request.getContextPath() + "list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
