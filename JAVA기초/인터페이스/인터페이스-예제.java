/*
 *  인터페이스 
 *  자바의 단일 상속을 보완하는 기능이 있다.
 *  인터페이스는 다중 상속이 가능하다. 
 */

class Vehicle1{
	void move(){
		System.out.println("움직인다.");
	}
}

interface Flyble{
	void fly();
}

interface Flyble2{
	void fly();
}

class Plane1 extends Vehicle1 implements Flyble,Flyble2{
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
}

public class InterFaceTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
