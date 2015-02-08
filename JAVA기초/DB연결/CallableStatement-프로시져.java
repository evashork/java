/*
 *  프로시져 테스트
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallubStatementTest {
	Connection con; 

	static{ // 클래스를 로딩할 때 단 한번 실행되는 영역
		
		try { // 예외처리
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName 파라미터로 지정된 클래스를 메모리로 읽어들이는 메소드
			
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
			System.out.println("-----프로시져 실행 전 -------");
			
			while (rs.next()) {
				System.out.println("name = " + rs.getString("name")
						+ ", 급여 = " + rs.getInt(2));;
			}
			System.out.println("-----------------");
			
			//프로시져 적용
			
			sql = "SELECT name FROM salary";
			pstmt = con.prepareStatement(sql);
			cstmt = con.prepareCall("{call adjust(?,?)}");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {  // 이름을 하나씩 가져옴
				cstmt.setString(1, rs.getString("name"));
				cstmt.setFloat(2, 0.05f);
				cstmt.executeUpdate();
			}
			
			System.out.println("-------------------------------------");
			
			sql = "SELECT name,pay FROM salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("-----프로시져 실행 후 -------");
			
			while (rs.next()) {
				System.out.println("name = " + rs.getString("name")
						+ ", 급여 = " + rs.getInt(2));;
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
