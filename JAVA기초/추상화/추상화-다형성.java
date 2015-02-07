/*
 *  �߻�Ŭ������ �̿��� ������
 */
abstract class Vehicle{
	abstract void move();
}
class Car extends Vehicle{
	@Override
	void move() {
		System.out.println("������ �ٴѴ�.");
	}
}

class Ship extends Vehicle{
	@Override
	void move() {
		System.out.println("���η� �ٴѴ�.");
	}
}

class Plane extends Vehicle{
	@Override
	void move() {
		System.out.println("�ϴ÷� �ٴѴ�.");
	}
}

class VehicleUse{
	void showMoveStyle(Vehicle vehicle){
		//��� ��ۼ����� �� ���� �� �ִ�.
		vehicle.move();
	}
}

public class AbstractTest3 {

	public static void main(String[] args) {
		Car car = new Car();
		Ship ship = new Ship();
		Plane plane = new Plane();
		
		VehicleUse vUse = new VehicleUse();
		
		vUse.showMoveStyle(car);
		vUse.showMoveStyle(ship);
		vUse.showMoveStyle(plane);
	}

}
