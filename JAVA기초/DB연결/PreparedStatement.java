/*
 * �ڹ��� ��� �۾�
 * 1.dbms�� ����̹� Ŭ������ ���ø����̼ǿ��� �ν� ������ ���丮�� �����Ѵ�.
 * ---> Ŭ�����н�(CLASSPATH) ȯ�溯��
 * �Ϲ������� lib������ �����.
 * 
 * 2.Ŭ���� ����
 * 
 * 3.import java.sql.* 
 * 
 * 4.����̹��� �޸𸮷� �ε�
 * 
 * 5.Connection ��ü ����
 * --- Connection �����ͺ��̽��� �����ϴ� ����
 * 
 * 6.Statement ��ü ����
 * --- Statement SQL������ DB ������ �����ϴ� ����
 * 6-1. int excuteUpdate(String sql) : SELECT �̿��� SQL����(CREATE,DROP,INSERT,DELETE,UPDATE..)�� 
 * ������ �� ����, ����� ����� ��ȯ��
 * 6-2. ResultSet executeQuery(String sql) : SELECT ������ ������ �� ����
 * 6-3. ResultSet�� ���ٸ� �������� ������ next()�� �̿��Ѵ�.
 * boolean next() : ���� ���ڵ�� Ŀ���� �̵���Ű�� �޼ҵ�, ���� ���ڵ尡 �����ϸ� true�� ��ȯ
 * T getT(int columName) : rs.getString(1) �÷��� ������ ã�´�. �÷� ������ 1���� �����Ѵ�. --->
 * T getT(String columName) : rs.getString("id") �÷��� �̸��� ã�´�. �����Ѵ�. 
 * Statement�� ������ SQL ���� ����, SQL ������ ������ ������ �Ľ� �ݺ�
 * ---> PreparedStatemt : ������ SQL ���� ����, �Ľ��� �ѹ��� �����Ѵ�.
 * 
 * Statement���ٴ� PreparedStatemt�� �ַ� ����Ѵ�.
 */

import java.sql.*;

public class ConnectionTest2 {
	Connection con; // 5. ���� ����
	
	// 4. static �ʱ�ȭ ��
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
	
	// 6. ���̺� ����
		void insert(String id, String name, String addr, String password){
			PreparedStatement pstmt = null; // sql�� ��´� ���� ���� �ʱ�ȭ
			
			//DB�۾��� �׻� ����ó���� �Ѵ�.
			try {
				connect(); //DB ����
				String sql = "INSERT INTO member VALUES(?,?,?,?)"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, addr);
				pstmt.setString(4, password);
				
				int insertCount = pstmt.executeUpdate(); // insert�� ������ �ľ�
				if(insertCount > 0){
					System.out.println("insert success");
				} 
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	// 6-2 ��� �ҷ�����
	void selectAll(){
		PreparedStatement psmt = null; // sql�� ��´�
		ResultSet rs = null; // sql ��� ���� ��´�. 
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			String sql = "SELECT * FROM member"; 
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()){ // ���̺��� �ο찡 �� ������ ����, rs.next() �� ������ false ��ȯ�ؼ� �ݺ��� ���� 
				System.out.println("���̵� : " + rs.getString(1) + ", �̸� : " + rs.getString("name")
						+ ", �ּ� : " + rs.getString("addr"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
			try {
				rs.close(); //rs�� Ŭ����
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//���̵� ���� PreparedStatement
	private void delete(String id) {
		PreparedStatement pstmt = null; // sql�� ��´� ���� ���� �ʱ�ȭ
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			String sql = "DELETE member" + " WHERE id = ?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int deleteCount = pstmt.executeUpdate(); // insert�� ������ �ľ�
			if(deleteCount > 0){
				System.out.println("insert success");
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// ���̵�� �˻�
	private void selectById(String id) {
		PreparedStatement pstmt = null; // sql�� ��´�
		ResultSet rs = null; // sql ��� ���� ��´�. 
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			String sql = "SELECT * FROM member where id = ? "; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){ // ���̺��� �ο찡 �� ������ ����, rs.next() �� ������ false ��ȯ�ؼ� �ݺ��� ���� 
				System.out.println("���̵� : " + rs.getString(1) + ", �̸� : " + rs.getString("name")
						+ ", �ּ� : " + rs.getString("addr"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
			try {
				rs.close(); //rs�� Ŭ����
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// ���̵� ����
		private void update(String id, String name) {
			// TODO Auto-generated method stub
			PreparedStatement pstmt = null; // sql�� ��´� ���� ���� �ʱ�ȭ
			
			//DB�۾��� �׻� ����ó���� �Ѵ�.
			try {
				connect(); //DB ����
				String sql = "UPDATE member" + " SET name = ?" + " WHERE id = ?"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				
				int updateCount = pstmt.executeUpdate(); // insert�� ������ �ľ�
				if(updateCount > 0){
					System.out.println("insert success");
				} 
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionTest2 ct = new ConnectionTest2();
		//ct.connect();
		ct.insert("zzz", "����", "����","zzz");
		System.out.println("��ü ȸ�� ���");
		ct.selectAll();
		
		System.out.println("zzz ���̵�� �˻�");
		ct.selectById("zzz");
		
		System.out.println("z ���̵��� ȸ���� �̸��� �ֹμ��� ����");
		ct.update("zzz","�ֹμ�");
		ct.selectById("zzz");
		
		System.out.println("z ���̵� ȸ�� ����");
		ct.delete("zzz");
		ct.selectAll();
	}
}
