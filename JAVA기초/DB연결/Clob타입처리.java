// CLOB ��뷮 ���� ó�� ���
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClobTest {
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
			StringBuffer sb = new StringBuffer(); //string��ü�� �ǵ��� StringBuffer�� �޴´�
			for (int i = 0; i < 10000; i++) {
				sb.append("ȫ�浿");
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sb.toString());
			//�ڹ��� �ֻ��� Ŭ������ Object Ŭ�����̴�. ��� Ŭ������ object�� ��� �޴´�.
			//toString() : �޼ҵ带 ȣ���� ��ü�� String Ÿ������ ��ȯ�ϴ� �޼ҵ�
			
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
				System.out.println("��ȣ : " + rs.getInt(1) + ", ���� : " + rs.getString("content"));
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
