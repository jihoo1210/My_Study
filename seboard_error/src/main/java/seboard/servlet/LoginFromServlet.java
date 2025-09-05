package seboard.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import seboard.dao.MemberDao;
import seboard.dto.MemberDto;


@WebServlet("/login")
public class LoginFromServlet extends HttpServlet {
   
   private static final String PEPPER = System.getenv("APP_PEPPER") != null ? 
                                      System.getenv("APP_PEPPER"):"";
    private MemberDao mDao;
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       request.setCharacterEncoding("UTF-8");
       String userid = request.getParameter("userid");
       String userpass = request.getParameter("userpass");
       String remember = request.getParameter("remember");
       
       mDao = new MemberDao();
       MemberDto mDto = null;
       
       try {
          
         mDto = mDao.findByUserid(userid);
          if(mDto == null) {
             request.setAttribute("loginError", "아이디 또는 비밀번호가 틀렸습니다.");
             request.getRequestDispatcher("/member/login.jsp").forward(request, response);
             return;
          }
          String input = userpass + PEPPER;
          boolean match = BCrypt.checkpw(input, mDto.getPassword());
          if(!match) {
             request.setAttribute("loginError", "아이디 또는 비밀번호가 틀렸습니다.");
             request.getRequestDispatcher("/member/login.jsp").forward(request, response);
             return;
          }
          
          //로그인 성공
          if("ok".equals(remember)) {
              Cookie rememberCookie = new Cookie("rememberid", userid);      
              rememberCookie.setMaxAge(60 * 60 * 24 * 7);  //7일간 저장
              rememberCookie.setPath(request.getContextPath());
              response.addCookie(rememberCookie);
          }else {
             //체크가 해제되어 있으면 기존에 저장되어 있던 쿠키도 삭제 한다.
             Cookie rememberCookie = new Cookie("rememberid", "");   
             rememberCookie.setMaxAge(0);
               rememberCookie.setPath(request.getContextPath());
               response.addCookie(rememberCookie);
          }
          //세션에 로그인 정보를 저장 (유저아이디를 세션에 저장)
          HttpSession session = request.getSession(true);
          session.setAttribute("loginUser", userid);
          session.setAttribute("loginId", mDto.getId());
          session.setAttribute("loginEmail", mDto.getEmail());
          session.setAttribute("loginName", mDto.getUsername());
          
          //성공후 메인 페이지로 리다이렉트
          response.sendRedirect(request.getContextPath() + "/index.jsp");
          
       }catch(SQLException e) {
          e.printStackTrace();
          //db오류
          request.setAttribute("loginError","데이터 베이스오류가 발생했습니다. 관리자에게 문의 하세요.");
          RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
            rd.forward(request, response);
            return; //오류 발생하면 메서드 종료
       }
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
      rd.forward(request, response);
   }

}
