package seboard.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seboard.db.JndiDb;

@WebServlet("/search")
public class SearchFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("useremail") == null ? null : request.getParameter("useremail");
		String usertel = request.getParameter("usertel") == null ? null : request.getParameter("usertel");
		String userid = request.getParameter("userid") == null ? null : request.getParameter("userid");
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(1);
		if (userid == null) {
			String sql = "SELECT * FROM members WHERE email=? and tel=?";
			try (Connection con = JndiDb.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setString(1, userEmail);
				pstmt.setString(2, usertel);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						session.setAttribute("searchResult", "아이디: " + rs.getString("userid"));
						response.sendRedirect( request.getContextPath() + "/member/search.jsp");
					} else {
						session.setAttribute("searchError", "일치하는 아이디를 찾을 수 없습니다.");
						response.sendRedirect( request.getContextPath() + "/member/search.jsp");
					}
				}
			} catch (Exception e) {
			}
		} else {
			String sql = "SELECT password FROM members WHERE userid = ?";
			try (Connection con = JndiDb.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, userid);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						session.setAttribute("searchResult", "비밀번호: " + rs.getString("password"));
						response.sendRedirect( request.getContextPath() + "/member/search.jsp");
					} else {
						session.setAttribute("searchError", "일치하는 비밀번호를 찾을 수 없습니다.");
						response.sendRedirect( request.getContextPath() + "/member/search.jsp");
					}
				}
			} catch (Exception e) {
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
