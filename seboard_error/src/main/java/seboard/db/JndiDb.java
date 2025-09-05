package seboard.db;

// 실제 데이터베이스와 통신하는 데 사용되는 연결을 나타내는 인터페이스
// SQL 쿼리를 실행하는 데 필요합니다.
import java.sql.Connection;
// 데이터베이스 접근 오류가 발생했을 때 던져지는 예외
import java.sql.SQLException;

// JNDI 명명 서비스에 대한 초기 컨텍스트를 제공
// JNDI에 등록된 자원을 찾아볼 수 있음
import javax.naming.InitialContext;
// JNDI 관련 오류(예: 지정된 이름을 찾을 수 없는 경우)가 발생했을 때 던져지는 예외
import javax.naming.NamingException;
// 데이터베이스 연결을 관리하는 인터페이스입니다. 
// 커넥션 풀(Connection Pool) 기능을 제공하여 데이터베이스 연결을 재사용하고 관리하는 역할을 합니다.
import javax.sql.DataSource;

public class JndiDb {
   private static DataSource ds;
   
   public static DataSource getDataSource() {
	   if(ds == null) {
		   // 멀티스레드 환경에서 ds 객체 초기화가 여러 번 동시에 일어나는 것을 방지하기 위해 사용
		   synchronized(JndiDb.class) {
			   if(ds == null) {
				   try {
					   ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/bbs1"); //JNDI 트리에서 지정된 이름의 자원을 찾아 반환하는 메서드
				   }catch(NamingException e) {
					   // NamingException이 발생했을 때 이를 런타임 예외로 변환하여 던집니다.
					   throw new RuntimeException("JNDI DadaSource Lookup 실패!" , e);
				   }
			   }
		   }
	   }
	   return ds;
   }
   
   //필요시 바로 커넥션 하는 메소드 하나 설정해 놓음
   public static Connection getConnection() throws SQLException {
	   // DataSource 객체로부터 데이터베이스 연결을 하나 얻어오는 메서드
	   return getDataSource().getConnection();
   }
}
