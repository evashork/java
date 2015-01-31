/*
 *  변수 : 메모리에 데이터를 저장할 수 있는 단위
 */

public class DateTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수선언 - 메모리 공간을 요청
		// 데이터 타입 + 변수명
		
		int var_int;
		
		int var1,var2,var3; // 데이터타입이 같을 경우 동시에 선언 가능
		
		// 변수에 데이터 저장
		var_int = 10;
		
		//변수 사용
		System.out.println("var_int = " + var_int);
		
		
		//정수형(byte,short,int,long)
		byte var_byte = 127; // 최대 127까지만 넣을 수 있음
		
		//논리형(boolean)
		boolean var_boolean = false;
		
		//문자형(char) : 반드시 한문자만 할당해야 한다. 공백X, 스페이스 가능
		char var_char = 'A'; // ''를 이용한다.
		
		//실수타입(float,double) - 기본타입은 double 이다.
		float var_float = 3.1f; //float의 실수는 반드시 f를 붙혀서 사용해야 한다.   
		
	}

}
