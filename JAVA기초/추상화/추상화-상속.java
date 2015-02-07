/*
 * 추상클래스 상속
 * 1-1. 다른 추상 클래스를 상속 받은 추상 클래스를 상속 받는 클래스는 
 * 상속 구조에 있는 모든 추상 메소드를 다 구현해야 한다
 */
abstract class AbClass1{
	abstract void abMethod1();
}

abstract class AbClass2 extends AbClass1{
	abstract void abMethod2();
}

class GeneralCalss extends AbClass2{
	@Override
	void abMethod1() {
		// 1.1
		
	}
	
	@Override
	void abMethod2() {
		// 1.1
		
	}
}
public class AbstractTest2 {

}
