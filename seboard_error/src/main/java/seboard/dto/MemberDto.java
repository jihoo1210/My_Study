package seboard.dto;

import java.time.LocalDateTime;

public class MemberDto {
   private int id;
   private String userid;
   private String password;  //추후 암호화
   private String username;
   private String email;
   private String tel;
   private int post;
   private String addr1;
   private String addr2;
   private LocalDateTime createdAt;
   
   //getter, setter
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pasword) {
		this.password = pasword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
//	@Override
//	public String toString() {
//		return "MemberDto [id=" + id + ", userid=" + userid + ", password=" + password + ", username=" + username
//				+ ", email=" + email + ", tel=" + tel + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2
//				+ ", createdAt=" + createdAt + "]";
//	}
  
}
