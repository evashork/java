import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDB {
	Connection con; // 5. 변수 선언
	// 4. static 초기화 블럭
	static{ // 클래스를 로딩할 때 단 한번 실행되는 영역
		
		try { // 예외처리
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName 파라미터로 지정된 클래스를 메모리로 읽어들이는 메소드
			
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
		
		// 사용자로부터 데이터 입력
		do{
			System.out.print("아이디 : ");
			String userId = sc.next();
			System.out.print("비밀번호 : ");
			String userPwd = sc.next();
			
			loginResult = ct.login(userId,userPwd);  // 로그인상태
			
			if(loginResult == 1){
				System.out.println("아이디가 없습니다.");
			}else if(loginResult == 2){
				System.out.println("비밀번호가 틀립니다.");
			}else{
				System.out.println("인증성공");
			}
		}while (loginResult != 3);	
	}
	
	
	// 로그인 메소드
	private int login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		Statement stmt = null; // sql을 담는다
		ResultSet rs = null; // sql 결과 값을 담는다. 
		int loginResult = 1; // 해당 아이디를 가지고 있는 회원 자체가 없는 경우
		
		//DB작업은 항상 예외처리를 한다.
		try {
			connect(); //DB 연결
			stmt = con.createStatement();
			String sql = "SELECT password FROM member where id = '"+ userId +"'"; 
			
			rs = stmt.executeQuery(sql); // 패스워드 값이 반환됨
			
			if(rs.next()){ // 셀렉트 된 값
				// 셀렉트의 값을 비교
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
			// DB작업은 실패여부에 상관없이 항상 finally에서 메모리를 클리어 시켜야한다.
			try {
				rs.close(); //rs도 클리어
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
