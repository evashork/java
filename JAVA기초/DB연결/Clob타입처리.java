// CLOB 대용량 파일 처리 방법
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClobTest {
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
	
	// 5.
	void connect(){
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"java", "java"); //url, user, password
			System.out.println("connection success!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(){
		String sql = "INSERT INTO clobtable (num,content) VALUES(1,?)";
		PreparedStatement pstmt = null;
		try {
			connect();
			StringBuffer sb = new StringBuffer(); //string객체는 되도록 StringBuffer로 받는다
			for (int i = 0; i < 10000; i++) {
				sb.append("홍길동");
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sb.toString());
			//자바의 최상위 클래스는 Object 클래스이다. 모든 클래스는 object를 상속 받는다.
			//toString() : 메소드를 호출한 객체를 String 타입으로 변환하는 메소드
			
			int insertCount = pstmt.executeUpdate();
			if (insertCount > 0) {
				System.out.println("insert success");
			}else{
				System.out.println("insert fail");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void select() {
		String sql = "SELECT * FROM clobtable";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("번호 : " + rs.getInt(1) + ", 내용 : " + rs.getString("content"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClobTest ct = new ClobTest();
		ct.insert();
		ct.select();
	}

}
