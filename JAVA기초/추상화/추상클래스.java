/*
 * 추상 클래스에는 일반 변수나 일반 메소드가 정의 될 수 있지만
 * 추상 메소드가 하나라도 존재하면 해당 클래스는 추상 클래스가 되어야 하고, abstract 예악어가
 * 지정되어야 한다.
 * 추상 클래스는 객체로 생성할 수 없다.
 * 추상 클래스의 기능은 자식 클래스에서 추상 클래스의 추상 메소드를 반드시 구현한 후 사용되어야 한다.
 * 
 * 추상 클래스는 반드시 재정의가 필요할 때 쓰인다.
 */

abstract class AbstractClass{
	//일반 변수
	int age;
	
	//일반 메소드
	void generalMethod(){
		System.out.println("일반 메소드");
	}
	
	//추상 메소드
	//정의부는 존재하지만 구현부가 존재하지 않는 메소드
	//메소드 정의 부에 abstract가 지정되어야 함.
	abstract void abstractMethod();
}

class AbstractClassChild extends AbstractClass{
	@Override
	void abstractMethod() {
		
	}
}

public class AbstractTest1 {
	
	public static void main(String[] args) {
		AbstractClass ac = new AbstractClassChild();
	}
	
}
