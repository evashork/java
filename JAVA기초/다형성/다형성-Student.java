/*
 * 다형성 자식클래스
 */
public class Student extends Person {
	String schooltype;
	int grade;
	
	@Override
	void shoeSleepStyle() {
		System.out.println("학생들의 수면스타일은 규칙적이다.");
	}
	
	//부모 클래스에 정의되지 않는 메소드
	void study(){
		System.out.println("공부를 한다.");
	}
}
