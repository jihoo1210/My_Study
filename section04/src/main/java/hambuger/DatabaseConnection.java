package hambuger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	//MYSQL 연결 정보
	//필드로 URL, ID, PASSWORD 생성
	private static final String URL = "jdbc:mysql://localhost:3306/sampledb";
	private static final String USER_ID = "root";
	private static final String USER_PASS = "jungmin6398";
	
	//Connection -> 싱글톤
	private static Connection connection = null;
	
	private DatabaseConnection() {};
	
	public static Connection getConnection() throws Exception{
		if(connection == null || connection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 새로운 connection 생성
			connection = DriverManager.getConnection(URL, USER_ID, USER_PASS);
			System.out.println("데이터 베이스 접속 성공.");
			return connection;
		} else {return connection;}
	}
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
