package hambuger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	//MYSQL ���� ����
	//�ʵ�� URL, ID, PASSWORD ����
	private static final String URL = "jdbc:mysql://localhost:3306/sampledb";
	private static final String USER_ID = "root";
	private static final String USER_PASS = "jungmin6398";
	
	//Connection -> �̱���
	private static Connection connection = null;
	
	private DatabaseConnection() {};
	
	public static Connection getConnection() throws Exception{
		if(connection == null || connection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ���ο� connection ����
			connection = DriverManager.getConnection(URL, USER_ID, USER_PASS);
			System.out.println("������ ���̽� ���� ����.");
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
