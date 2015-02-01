
public class OperationTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 산술연산 (+,-,*,/,%)
		int na = 10 % 3; //10을 3으로 나눈 나머지
		System.out.println("10 % 3 = " + na);
		
		// 연산 후 대입연산자
		na += 3;
		// na = na + 3 : na 변수 값에 3을 더한 값을 할당한다. 
		System.out.println("na += 3 = " + na);
		
		// 논리 연산자 true 나 false 값을 리턴해준다.
		
		
		// 증감연산자 (++;--)
		// 피연산자 값을 1씩 증가시키거나 감소시키는 연산자
		// 증감연산자는 피연산자의 앞에 올수도 있고 뒤에 올수도 있다.
		// 앞에 올 경우 전치연산자, 뒤에 올 경우 후치연산자
		
		// 전치연산자 : 증감연산자를 먼저 실행하고 다른 연산을 실행한다.
		int x = 5;
		int y = ++x;
		System.out.println(y); //값은 6
		
		// 후치연산자 : 다른 연산자를 먼저 실행하고 증감연산자가 실행된다.
		x = 5;
		y = x++;
		System.out.println(y); //값은 5		
		
		// 삼항연산자
		// (조건식) ? 조건식이 true를 반환할 경우 반활될 값 : 조건식이 false를 반환할 경우 반활될 값
		// 삼항연산자를 이용해서 절대값을 구함
		
		x = -10;
		int absX = (x >= 0) ? x : -x;
		System.out.println(absX); // 무조건 10을 반환함
	}
}
