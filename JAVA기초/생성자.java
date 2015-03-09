/*
 *  생성자
 *  객체를 생성할 때 new 연산자에 의해 단한번 호출
 *  객체를 생성할 때 맴버 변수값을 초기화 시키는 용도로 주로 사용된다.
 *  
 *  규칙
 *  1-1.클래스에 생성자를 하나도 정의하지 않으면 컴파일러가 자동으로 빈생성자를 생성함.
 *  1-2.클래스에 인자 있는 생성자를 하나라도 정의하면 빈생성자를 생성해 주지 않은다.
 *  생성자의 이름은 클래스 이름과 동일해야 한다.
 *  생성자는 리턴 타입이 없다. - 리턴이 있으면 메소드로 인식 된다.
 *  생성자의 접근제한자는 클래스의 접근 제한자와 동일할 필요가 없다.
 *  
 */

class Data{
	public Data() { 
		// 1-1.클래스에 생성자를 하나도 정의하지 않으면 컴파일러가 자동으로 빈생성자를 생성함.
		// 객체를 선언하면 Data data = new Data() 
		// 생성자 안의 선언들이 자동으로 실행된다.
	}
}

class Data1{
	int var;
	public Data1(int var) {
		// 1-2.클래스에 인자 있는 생성자를 하나라도 정의하면 빈생성자를 생성해 주지 않은다.
		this.var = var;
	}
}

public class ConstructTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		// Data1 data = new Data1(); 1-2
	}

}
