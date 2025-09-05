package seboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import seboard.db.JndiDb;
import seboard.dto.MemberDto;

public class MemberDao {

	//insert
	public int insert(MemberDto m) throws SQLException {
		
		String sql = "INSERT INTO members (userid, password, username, email, tel, post, addr1, addr2)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection conn = JndiDb.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			pstmt.setString(1, m.getUserid());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUsername());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getTel());
			pstmt.setInt(6, m.getPost());
			pstmt.setString(7, m.getAddr1());
			pstmt.setString(8, m.getAddr2());
			
			int gkey = pstmt.executeUpdate();  //gkey는 성공 1, 실패 0만 리턴
			if(gkey == 0) return 0;
			//gkey에서 insert 성공을 리턴했을 경우 등록된 값을 담아 id 담음 rs.getInt(1) 첫 번째 담긴 것 리턴
			//사실 id값을 리턴 받는것은 불필요, 성공, 실패만 알면 됨. 추수 답글 등에 필요한 쿼리라 미리 만들어 봄
			try(ResultSet rs = pstmt.getGeneratedKeys()){ 
				if(rs.next()) {
					int id = rs.getInt(1);
					m.setId(id);
					return id;
				}
			}
			
			return gkey;
		}
		
	}
	
	
	//update
	public int update(MemberDto m) throws SQLException {
		
		String sql = "UPDATE members SET username=?, email=?, tel=?, post=?, addr1=?, addr2 = ?, " +
		             " password = COALESCE(NULLIF(?,''), password) " + //널값이면 기존 비밀번호 입력 
				     " WHERE userid=?";
		try(Connection conn = JndiDb.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, m.getUsername());
				pstmt.setString(2, m.getEmail());
				pstmt.setString(3, m.getTel());
				pstmt.setInt(4, m.getPost());
				pstmt.setString(5, m.getAddr1());
				pstmt.setString(6, m.getAddr2());
								
				//m.getPassword()가 null 이거나 "" 이면 NULLIF(?,'') 가 NULL을 리턴
				//COALESCE(NULL, password) 에서 기존 값을 유지
				pstmt.setString(7, m.getPassword());
				pstmt.setString(8, m.getUserid());
			   
				return pstmt.executeUpdate();
			}
	}
	
	
	//delete
	
	//자기자신 조회 select
	
	//로그인 확인 select  아이디와 비밀번호를 매개변수로 받아서 MemberDto타입으로 리턴한다.
	/*
	public MemberDto findByUserid(String userid, String userpass) throws SQLException {
		
		String sql = "select * from members where userid=?"; //아이디가 같은지 조회
	
		try(Connection conn = JndiDb.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, userid);
		
			try(ResultSet rs = pstmt.executeQuery()) {
				if(!rs.next()) return null;  //아이디가 없으면 null로 리턴
			
				//아이디가 있으면 비밀번호가 같은지 조회
				if(rs.getString("password").equals(userpass)) { 
				
				   MemberDto m = new MemberDto();
				   m.setId(rs.getInt("id"));
				   m.setUserid(rs.getString("userid"));
				   m.setPassword(rs.getString("password"));
				   m.setUsername(rs.getString("username"));
			   	   m.setEmail(rs.getString("email"));
				   m.setTel(rs.getString("tel"));
				   m.setPost(rs.getInt("post"));
				   m.setAddr1(rs.getString("addr1"));
				   m.setAddr2(rs.getString("addr2"));
				
			        return m;	
				}else {
					return null;
				}
			}
		}
	}
	*/
	
    public MemberDto findByUserid(String userid) throws SQLException {
		
		String sql = "select * from members where userid=?"; //아이디가 같은지 조회
	
		try(Connection conn = JndiDb.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, userid);
		
			try(ResultSet rs = pstmt.executeQuery()) {
				if(!rs.next()) return null;  //아이디가 없으면 null로 리턴
					
				   MemberDto m = new MemberDto();
				   m.setId(rs.getInt("id"));
				   m.setUserid(rs.getString("userid"));
				   m.setPassword(rs.getString("password"));
				   m.setUsername(rs.getString("username"));
			   	   m.setEmail(rs.getString("email"));
				   m.setTel(rs.getString("tel"));
				   m.setPost(rs.getInt("post"));
				   m.setAddr1(rs.getString("addr1"));
				   m.setAddr2(rs.getString("addr2"));
				
			       return m;	
				}
			}
		}
    
    //아이디, 이메일, 전화번호 중복 확인
    public Boolean existsByUserid(String val)  throws SQLException {
    	String sql = "SELECT 1 FROM members where userid = ?";
    	try(Connection conn = JndiDb.getConnection();
    	    PreparedStatement pstmt = conn.prepareStatement(sql)){
    	    	pstmt.setString(1, val);
    	    	
    	    	try(ResultSet rs = pstmt.executeQuery()){
    	    		return rs.next();
    	    	}
    	    }		 
    }
    
    public Boolean existsByEmail(String val)  throws SQLException {
    	String sql = "SELECT 1 FROM members where email = ?";
    	try(Connection conn = JndiDb.getConnection();
    	    PreparedStatement pstmt = conn.prepareStatement(sql)){
    	    	pstmt.setString(1, val);
    	    	
    	    	try(ResultSet rs = pstmt.executeQuery()){
    	    		return rs.next();
    	    	}
    	    }		 
    }
    
    public Boolean existsByTel(String val)  throws SQLException {
    	String sql = "SELECT 1 FROM members where tel = ?";
    	try(Connection conn = JndiDb.getConnection();
    	    PreparedStatement pstmt = conn.prepareStatement(sql)){
    	    	pstmt.setString(1, val);
    	    	
    	    	try(ResultSet rs = pstmt.executeQuery()){
    	    		return rs.next();
    	    	}
    	    }		 
    }
    
    
}
