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
 */

import java.sql.*;

public class ConnectionTest {
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
	
	// 6. Statement
	void insert(String id, String name, String addr){
		Statement stmt = null; // sql�� ��´� ���� ���� �ʱ�ȭ
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			stmt = con.createStatement();
			String sql = "INSERT INTO member VALUES('"+ id +"','" + name +"','" + addr + "')"; 
			//INSERT INTO member VALUSE('aaa','Ÿ��','����')
			//INSERT INTO member(id,name) VALUSE('aaa','Ÿ��')
			
			int insertCount = stmt.executeUpdate(sql); // insert�� ������ �ľ�
			if(insertCount > 0){
				System.out.println("insert success");
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	// 6-2
	void selectAll(){
		Statement stmt = null; // sql�� ��´�
		ResultSet rs = null; // sql ��� ���� ��´�. 
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			stmt = con.createStatement();
			String sql = "SELECT * FROM member"; 
			
			rs = stmt.executeQuery(sql);
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
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// ���̵� ����
	private void delete(String id) {
		Statement stmt = null; // sql�� ��´� ���� ���� �ʱ�ȭ
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			stmt = con.createStatement();
			String sql = "DELETE member" + " WHERE id = '" + id + "'"; 
			
			int deleteCount = stmt.executeUpdate(sql); // insert�� ������ �ľ�
			if(deleteCount > 0){
				System.out.println("insert success");
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// ���̵�� �˻�
	private void selectById(String id) {
		Statement stmt = null; // sql�� ��´�
		ResultSet rs = null; // sql ��� ���� ��´�. 
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			stmt = con.createStatement();
			String sql = "SELECT * FROM member where id = '"+ id +"'"; 
			
			rs = stmt.executeQuery(sql);
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
				stmt.close();
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
			Statement stmt = null; // sql�� ��´� ���� ���� �ʱ�ȭ
			
			//DB�۾��� �׻� ����ó���� �Ѵ�.
			try {
				connect(); //DB ����
				stmt = con.createStatement();
				String sql = "UPDATE member" + " SET name = '" + name + "'" + " WHERE id = '" + id + "'"; 
				
				int updateCount = stmt.executeUpdate(sql); // insert�� ������ �ľ�
				if(updateCount > 0){
					System.out.println("insert success");
				} 
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// DB�۾��� ���п��ο� ������� �׻� finally���� �޸𸮸� Ŭ���� ���Ѿ��Ѵ�.
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionTest ct = new ConnectionTest();
		//ct.connect();
		//ct.insert("zzz", "����", "����");
		System.out.println("��ü ȸ�� ���");
		ct.selectAll();
		
		System.out.println("zzz ���̵�� �˻�");
		ct.selectById("zzz");
		
		System.out.println("z ���̵��� ȸ���� �̸��� �ֹμ��� ����");
		ct.update("z","�ֹμ�");
		ct.selectById("zzz");
		
		System.out.println("z ���̵� ȸ�� ����");
		ct.delete("zzz");
		ct.selectAll();
	}
}
