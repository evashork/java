import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransectionTest {
	// DB ����
	Connection con;
	static{ 
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
		PreparedStatement pstmt = null;

		boolean isSuccess = false; //
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"java", "java"); //url, user, password
			String sql = "CREATE TABLE test1(id VARCHAR2(12),passwd VARCHAR2(12))";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			//Ʈ������
			con.setAutoCommit(false); // ���� false�϶� �۾��� �޸𸮻󿡼��� �̷������
			sql = "INSERT INTO test1 VALUES('aaa','1111')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES('bbb','2222')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

			sql = "INSERT INTO test1 VALUES('ccc','3333)"; // �����߻� ��Ŵ
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			isSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(isSuccess){
					con.commit();
					//Ʈ������ �߿� ���� �� sql ������ �ϼ� �����ش�.
					
				}else{
					con.rollback();
					//Ʈ������ �� ������ �߻��ϸ� ��� �۾� ���
				}
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
