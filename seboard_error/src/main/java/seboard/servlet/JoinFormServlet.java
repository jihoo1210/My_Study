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


@WebServlet("/join")
public class JoinFormServlet extends HttpServlet {
   
   private static final String PEPPER = System.getenv("APP_PEPPER") != null ? System.getenv("APP_PEPPER"):"";

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      
        MemberDto mDto = new MemberDto();
        
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
           //비밀번호 + 페퍼 => 해시(Bcrypt)
           String passwordForHash = userpass + PEPPER;
           
           //암호화 salt 일반적으로 10~12
           String hashed = BCrypt.hashpw(passwordForHash, BCrypt.gensalt(8));
           
           mDto.setUserid(userid);
           mDto.setPassword(hashed);
            mDto.setUsername(username);
            mDto.setEmail(useremail);
            mDto.setTel(usertel);
            mDto.setPost(post);
            mDto.setAddr1(addr1);
            mDto.setAddr2(addr2);
            
            MemberDao mDao = new MemberDao();
            String attn = null;
            try {
             int rsid = mDao.insert(mDto);
             if(rsid > 0) {
                
                attn = "<script>alert('회원이 되심을 환영합니다. 로그인 하십시오.'); location.href='login.jsp';</script>"; 
               
             }else {
                attn = "<script>alert('회원가입에 실패했습니다. 다시 시도해 주세요.'); location.href='join.jsp';<script>";
             }
          
            } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
                attn = "<script>alert('서버오류가 발생해 회원가입에 실패했습니다. 관리자에게 문의 하세요.'); location.href='member/join.jsp';<script>";
          }
            
            out.print(attn);
            out.close();
           
           
        }catch(Exception e) {
           e.printStackTrace();
        }
        
        
        //System.out.println(mDto.toString());
      
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
