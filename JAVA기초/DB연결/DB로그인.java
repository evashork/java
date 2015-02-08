import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDB {
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
	
	void connect(){
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"java", "java"); //url, user, password
			System.out.println("connection success!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		LoginDB ct = new LoginDB();
		
		int loginResult = 0;
		
		// ����ڷκ��� ������ �Է�
		do{
			System.out.print("���̵� : ");
			String userId = sc.next();
			System.out.print("��й�ȣ : ");
			String userPwd = sc.next();
			
			loginResult = ct.login(userId,userPwd);  // �α��λ���
			
			if(loginResult == 1){
				System.out.println("���̵� �����ϴ�.");
			}else if(loginResult == 2){
				System.out.println("��й�ȣ�� Ʋ���ϴ�.");
			}else{
				System.out.println("��������");
			}
		}while (loginResult != 3);	
	}
	
	
	// �α��� �޼ҵ�
	private int login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		Statement stmt = null; // sql�� ��´�
		ResultSet rs = null; // sql ��� ���� ��´�. 
		int loginResult = 1; // �ش� ���̵� ������ �ִ� ȸ�� ��ü�� ���� ���
		
		//DB�۾��� �׻� ����ó���� �Ѵ�.
		try {
			connect(); //DB ����
			stmt = con.createStatement();
			String sql = "SELECT password FROM member where id = '"+ userId +"'"; 
			
			rs = stmt.executeQuery(sql); // �н����� ���� ��ȯ��
			
			if(rs.next()){ // ����Ʈ �� ��
				// ����Ʈ�� ���� ��
				if(userPwd.equals(rs.getString("password"))){ 
					loginResult = 3;
				}
				else{
					loginResult = 2;	
				}
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
		return loginResult;
	}
}
