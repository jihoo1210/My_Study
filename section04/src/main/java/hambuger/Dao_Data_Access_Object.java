package hambuger;

import java.sql.Connection;
import java.sql.PreparedStatement;
// 데이터베이스와의 상호작용
public class Dao_Data_Access_Object {
	
	//insert
	public boolean insertOrder(Dto_Data_transfer_Object dto) {
		// SQL 명령 구조 생성
		String sql = "INSERT INTO hambuger (size, ingredients, drink, request) VALUES (?, ? ,? ,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 싱글톤 커넥션 객체 얻기
			con = DatabaseConnection.getConnection();
			// 얻은 싱글톤 객체에 SQL 명령문 준비
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getSize());
			pstmt.setString(2, dto.getIngredients());
			pstmt.setString(3, dto.getDrink());
			pstmt.setString(4, dto.getRequest());
			
			// 명령문 실행 및 다음 준비된 명령 입력 준비
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				} 				
			}	catch (Exception e) {
					e.printStackTrace();
			} 
		}
		return false;}
}
/* - maven : xml
 * - gradle : springBoot, modile
 */