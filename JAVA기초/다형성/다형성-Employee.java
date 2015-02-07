/*
 * 다형성 자식
 */
public class Employee extends Person {
	String dept;
	int age = 20;
	
	@Override
	void shoeSleepStyle() {
		System.out.println("직장인들의 수면 시간은 불규칙적이다.");
	}
}
