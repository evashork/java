import java.util.Scanner;


public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbId = "java";
		String dbPwd = "java";
		Scanner sc = new Scanner(System.in);
		int loginResult;  // 로그인상태
		
		// 사용자로부터 데이터 입력
		do{
			System.out.print("아이디 : ");
			String userId = sc.next();
			System.out.print("비밀번호 : ");
			String userPwd = sc.next();
		
			// 연산
			if(!dbId.equals(userId)){
				loginResult = 1;
				//아이디가 같지 않을 경우
			}else if(!dbPwd.equals(userPwd)){
				loginResult = 2;
				//아이디는 같지만 비밀번호가 틀릴 경우
			}else{
				loginResult = 3;
				//모두 다 만족할 경우
			}
		
			if(loginResult == 1){
				System.out.println("아이디가 없습니다.");
			}else if(loginResult == 2){
				System.out.println("비밀번호가 틀립니다.");
			}else{
				System.out.println("인증성공");
			}
		}while (loginResult != 3);	
	}

}
