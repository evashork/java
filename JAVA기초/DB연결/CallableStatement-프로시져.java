/*
 *  ���ν��� �׽�Ʈ
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallubStatementTest {
	Connection con; 

	static{ // Ŭ������ �ε��� �� �� �ѹ� ����Ǵ� ����
		
		try { // ����ó��
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName �Ķ���ͷ� ������ Ŭ������ �޸𸮷� �о���̴� �޼ҵ�
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"java", "java"); //url, user, password
			String sql = "SELECT name,pay FROM salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("-----���ν��� ���� �� -------");
			
			while (rs.next()) {
				System.out.println("name = " + rs.getString("name")
						+ ", �޿� = " + rs.getInt(2));;
			}
			System.out.println("-----------------");
			
			//���ν��� ����
			
			sql = "SELECT name FROM salary";
			pstmt = con.prepareStatement(sql);
			cstmt = con.prepareCall("{call adjust(?,?)}");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {  // �̸��� �ϳ��� ������
				cstmt.setString(1, rs.getString("name"));
				cstmt.setFloat(2, 0.05f);
				cstmt.executeUpdate();
			}
			
			System.out.println("-------------------------------------");
			
			sql = "SELECT name,pay FROM salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("-----���ν��� ���� �� -------");
			
			while (rs.next()) {
				System.out.println("name = " + rs.getString("name")
						+ ", �޿� = " + rs.getInt(2));;
			}
			System.out.println("-----------------");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			try {
				rs.close();
				pstmt.close();
				cstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
