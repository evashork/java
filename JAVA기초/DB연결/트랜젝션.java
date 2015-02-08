import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransectionTest {
	// DB 연결
	Connection con;
	static{ 
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
		PreparedStatement pstmt = null;

		boolean isSuccess = false; //
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"java", "java"); //url, user, password
			String sql = "CREATE TABLE test1(id VARCHAR2(12),passwd VARCHAR2(12))";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			//트랜젝션
			con.setAutoCommit(false); // 값이 false일때 작업이 메모리상에서만 이루어진다
			sql = "INSERT INTO test1 VALUES('aaa','1111')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES('bbb','2222')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

			sql = "INSERT INTO test1 VALUES('ccc','3333)"; // 오류발생 시킴
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			isSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(isSuccess){
					con.commit();
					//트랜젝션 중에 실행 된 sql 구문을 완성 시켜준다.
					
				}else{
					con.rollback();
					//트랙젝션 중 오류가 발생하면 모든 작업 취소
				}
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
