package seboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import seboard.db.JndiDb;
import seboard.dto.BoardDto;

public class BoardDao {
	
	// 게시글 수 가져옴
	public int bbsCount() throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT count(*) FROM bbs");
		try(Connection con = JndiDb.getConnection();
				Statement st = con.createStatement()) {
			try(ResultSet rs = st.executeQuery(sql.toString());) {
				rs.next();
				return rs.getInt(1);
			}
		}
	}
	// 게시글 목록
	public List<BoardDto> findAll() throws SQLException {
		String sql = "SELECT * FROM bbs ORDER BY id DESC";

		try(Connection con = JndiDb.getConnection();
			Statement st = con.createStatement();) {
				List<BoardDto> list = new ArrayList<>();
				try (ResultSet rs = st.executeQuery(sql)) {
					while(rs.next()) {
						BoardDto d = new BoardDto();
						d.setId(rs.getInt("id"));
						d.setPass(rs.getString("pass"));
						d.setTitle(rs.getString("title"));
						d.setContent(rs.getString("content"));
						d.setHit(rs.getInt("hit"));
						d.setCreateAt(rs.getTimestamp("created_at"));
						list.add(d);
					}
				}
				return list;
		}
	}
	// 상세글 가져오기
	public BoardDto findById(int id) throws SQLException{
		String sql = "SELECT * FROM bbs WHERE id = ?";
		try(Connection con = JndiDb.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
				try(ResultSet rs = pstmt.executeQuery()) {
					if(!rs.next()) return null;
					BoardDto dto = new BoardDto();
					dto.setId(rs.getInt("id"));
					dto.setPass(rs.getString("pass"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setHit(rs.getInt("hit"));
					dto.setCreateAt(rs.getTimestamp("created_at"));
					return dto;
				}
		}
	}
	// 글쓰기
	public int insert(BoardDto dto) throws SQLException {
		String sql = "INSERT INTO bbs (pass, title, content, writer) VALUES (?, ?, ?, ?)";
		try(Connection con = JndiDb.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, dto.getPass());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getWriter());
			return pstmt.executeUpdate();
		}
	}
	// 비밀번호 확인
	// 글 수정
	// 글 삭제
}
