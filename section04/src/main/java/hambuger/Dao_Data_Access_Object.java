package hambuger;

import java.sql.Connection;
import java.sql.PreparedStatement;
// �����ͺ��̽����� ��ȣ�ۿ�
public class Dao_Data_Access_Object {
	
	//insert
	public boolean insertOrder(Dto_Data_transfer_Object dto) {
		// SQL ��� ���� ����
		String sql = "INSERT INTO hambuger (size, ingredients, drink, request) VALUES (?, ? ,? ,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// �̱��� Ŀ�ؼ� ��ü ���
			con = DatabaseConnection.getConnection();
			// ���� �̱��� ��ü�� SQL ��ɹ� �غ�
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getSize());
			pstmt.setString(2, dto.getIngredients());
			pstmt.setString(3, dto.getDrink());
			pstmt.setString(4, dto.getRequest());
			
			// ��ɹ� ���� �� ���� �غ�� ��� �Է� �غ�
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