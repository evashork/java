/*
 *  �������̽� 
 *  �ڹ��� ���� ����� �����ϴ� ����� �ִ�.
 *  �������̽��� ���� ����� �����ϴ�. 
 */

class Vehicle1{
	void move(){
		System.out.println("�����δ�.");
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
