/*
 *  형변환 규칙
 *  
 *  1. 변수에 데이터 할당 시 형변환 규칙
 *  
 *  1-1. 변수의 데이터 타입보다 더 작은 타입의 값을 할당하는 경우
 *  - 값의 데이터 타입이 자동으로 변수의 데이터타입으로 형변환 된 후 할당됨.
 *  
 *  1-2. 변수의 데이터 타입보다 더 큰 타입의 값을 할당하는 경우
 *  - 컴파일 오류 발생, 명시적 캐스팅이 필요함, 값 손실이 발생할 수 있다.
 *  
 *  
 *  2. 연산시 형변환
 *  
 *  2-1. 피연산자 중 보다 큰 타입으로 형변환된 후 연산된다.
 *  2-2. int 보다 작은 정수 타입을 연산 할 때는 무조건 int 타입으로 형변환되어 연산됨.
 *  2-3. 실수 타입과 정수 타입을 연산할 때에는 데이터 타입의 크기와 상관없이 무조건 실수로 형변환된다.
 * 
*/
public class ConversitonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1-1
		byte byte1 = 10;
		int int1 = byte1;
		
		// 1-2
		int int2 = 200;
		byte byte2 = (byte)int2;
		
		System.out.println("byte2 = " + byte2); 
		// 결과값 byte2 = -56;
		
		
		// 2-1
		int2 = 100;
		long long1 = 200;
		long result = int2 + long1; // int로 받을 수 없다.
		
		// 2-2
		byte1 = 1;
		short short1 = 2;
		int result2 = byte1 + short1; // int보다 작은 정수는 무조건 int로 형변환 된다.
		
		// 2-3
		long1 = 8; // 크기는 float보다 long이 크다
		float float1 = 2.1f;
		float result3 = long1 + float1; // 무조건 float로 받아야 한다.
		
	}

}
