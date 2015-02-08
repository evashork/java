/*
 * 자바의 디비 작업
 * 1.dbms의 드라이버 클래스를 에플리케이션에서 인식 가능한 디렉토리에 복사한다.
 * ---> 클래스패스(CLASSPATH) 환경변수
 * 일반적으로 lib폴더를 만든다.
 * 
 * 2.클래스 생성
 * 
 * 3.import java.sql.* 
 * 
 * 4.드라이버를 메모리로 로딩
 * 
 * 5.Connection 객체 생성
 * --- Connection 데이터베이스에 연결하는 역할
 * 
 * 6.Statement 객체 생성
 * --- Statement SQL구문을 DB 서버로 전송하는 역할
 * 6-1. int excuteUpdate(String sql) : SELECT 이외의 SQL구문(CREATE,DROP,INSERT,DELETE,UPDATE..)을 
 * 실행할 때 사용됨, 적용된 행수를 반환함
 * 6-2. ResultSet executeQuery(String sql) : SELECT 구문을 실행할 때 사용됨
 * 6-3. ResultSet은 한줄만 가져오기 때문에 next()를 이용한다.
 * boolean next() : 다음 레코드로 커서를 이동시키는 메소드, 다음 레코드가 존재하면 true를 반환
 * T getT(int columName) : rs.getString(1) 컬럼을 순서를 찾는다. 컬럼 순서는 1부터 시작한다. --->
 * T getT(String columName) : rs.getString("id") 컬럼의 이름을 찾는다. 권장한다. 
 * Statement는 정적인 SQL 구문 전송, SQL 구문을 전송할 때마다 파싱 반복
 * ---> PreparedStatemt : 동적인 SQL 구문 전송, 파싱을 한번만 수행한다.
 * 
 * Statement보다는 PreparedStatemt를 주로 사용한다.
 */

import java.sql.*;

public class ConnectionTest2 {
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
	
	// 6. 테이블 생성
		void insert(String id, String name, String addr, String password){
			PreparedStatement pstmt = null; // sql을 담는다 로컬 변수 초기화
			
			//DB작업은 항상 예외처리를 한다.
			try {
				connect(); //DB 연결
				String sql = "INSERT INTO member VALUES(?,?,?,?)"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, addr);
				pstmt.setString(4, password);
				
				int insertCount = pstmt.executeUpdate(); // insert된 갯수를 파악
				if(insertCount > 0){
					System.out.println("insert success");
				} 
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// DB작업은 실패여부에 상관없이 항상 finally에서 메모리를 클리어 시켜야한다.
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	// 6-2 모두 불러오기
	void selectAll(){
		PreparedStatement psmt = null; // sql을 담는다
		ResultSet rs = null; // sql 결과 값을 담는다. 
		
		//DB작업은 항상 예외처리를 한다.
		try {
			connect(); //DB 연결
			String sql = "SELECT * FROM member"; 
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()){ // 테이블의 로우가 다 끝날때 까지, rs.next() 가 없으면 false 반환해서 반복이 끝남 
				System.out.println("아이디 : " + rs.getString(1) + ", 이름 : " + rs.getString("name")
						+ ", 주소 : " + rs.getString("addr"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB작업은 실패여부에 상관없이 항상 finally에서 메모리를 클리어 시켜야한다.
			try {
				rs.close(); //rs도 클리어
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//아이디 삭제 PreparedStatement
	private void delete(String id) {
		PreparedStatement pstmt = null; // sql을 담는다 로컬 변수 초기화
		
		//DB작업은 항상 예외처리를 한다.
		try {
			connect(); //DB 연결
			String sql = "DELETE member" + " WHERE id = ?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int deleteCount = pstmt.executeUpdate(); // insert된 갯수를 파악
			if(deleteCount > 0){
				System.out.println("insert success");
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB작업은 실패여부에 상관없이 항상 finally에서 메모리를 클리어 시켜야한다.
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// 아이디로 검색
	private void selectById(String id) {
		PreparedStatement pstmt = null; // sql을 담는다
		ResultSet rs = null; // sql 결과 값을 담는다. 
		
		//DB작업은 항상 예외처리를 한다.
		try {
			connect(); //DB 연결
			String sql = "SELECT * FROM member where id = ? "; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){ // 테이블의 로우가 다 끝날때 까지, rs.next() 가 없으면 false 반환해서 반복이 끝남 
				System.out.println("아이디 : " + rs.getString(1) + ", 이름 : " + rs.getString("name")
						+ ", 주소 : " + rs.getString("addr"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// DB작업은 실패여부에 상관없이 항상 finally에서 메모리를 클리어 시켜야한다.
			try {
				rs.close(); //rs도 클리어
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 아이디 수정
		private void update(String id, String name) {
			// TODO Auto-generated method stub
			PreparedStatement pstmt = null; // sql을 담는다 로컬 변수 초기화
			
			//DB작업은 항상 예외처리를 한다.
			try {
				connect(); //DB 연결
				String sql = "UPDATE member" + " SET name = ?" + " WHERE id = ?"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				
				int updateCount = pstmt.executeUpdate(); // insert된 갯수를 파악
				if(updateCount > 0){
					System.out.println("insert success");
				} 
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// DB작업은 실패여부에 상관없이 항상 finally에서 메모리를 클리어 시켜야한다.
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
		ct.insert("zzz", "히요", "마산","zzz");
		System.out.println("전체 회원 목록");
		ct.selectAll();
		
		System.out.println("zzz 아이디로 검색");
		ct.selectById("zzz");
		
		System.out.println("z 아이디의 회원의 이름을 최민수로 변경");
		ct.update("zzz","최민수");
		ct.selectById("zzz");
		
		System.out.println("z 아이디 회원 삭제");
		ct.delete("zzz");
		ct.selectAll();
	}
}
