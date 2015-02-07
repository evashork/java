/*
 *  다형성 자식클래스
 */
public class President extends Person {
	String nation;
	int salary;
	
	@Override
	void shoeSleepStyle() {
		// TODO Auto-generated method stub
		System.out.println("대통령은 항상 업무에 시달려 수면시간이 부족하다");
	}
}
