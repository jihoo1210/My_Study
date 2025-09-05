package seboard.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import seboard.dao.MemberDao;
import seboard.dto.MemberDto;


@WebServlet("/update")
public class MemberUpdate extends HttpServlet {

   private static final String PEPPER = System.getenv("APP_PEPPER") != null ? System.getenv("APP_PEPPER"):"";
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
        String userid = request.getParameter("userid");
        String userpass = request.getParameter("userpass");
        String username = request.getParameter("username");
        String useremail = request.getParameter("useremail");
        String usertel = request.getParameter("usertel");
        int post = 0;
        String strPost = request.getParameter("post");
        if(strPost != null && !strPost.isEmpty()) {
           post = Integer.parseInt(strPost);
        }
        String addr1 = request.getParameter("addr");
        String addr2 = request.getParameter("addr2");
      
      try {
       MemberDto mDto = new MemberDto();
           
           mDto.setUserid(userid);
           String userpassForHash = userpass + PEPPER;
           String hashed = BCrypt.hashpw(userpassForHash, BCrypt.gensalt(8));
           mDto.setPassword(hashed);
           
           mDto.setUsername(username);
           mDto.setEmail(useremail);
           mDto.setTel(usertel);
           mDto.setPost(post);
           mDto.setAddr1(addr1);
           mDto.setAddr2(addr2);
           
           try {
              MemberDao dao = new MemberDao();
              int updated = dao.update(mDto);
              String str = null;
              if(updated > 0) {
                 str = "<script>alert('성공적으로 수정했습니다.');location.href='member/edit.jsp';</script>";
           
              }else {
                 str = "<script>alert('수정에 실패했습니다.');location.href='member/edit.jsp';</script>";       
              }
              out.print(str);
           }catch(SQLException e) {
              e.printStackTrace();
              String strerror = "<script>alert('서버 오류로 수정불가.');location.href='member/edit.jsp';</script>"; 
               out.print(strerror);
           }
           
      }catch(Exception e) {}    
   }

}
