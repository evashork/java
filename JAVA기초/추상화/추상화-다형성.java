/*
 *  추상클래스를 이용한 다형성
 */
abstract class Vehicle{
	abstract void move();
}
class Car extends Vehicle{
	@Override
	void move() {
		System.out.println("차도로 다닌다.");
	}
}

class Ship extends Vehicle{
	@Override
	void move() {
		System.out.println("수로로 다닌다.");
	}
}

class Plane extends Vehicle{
	@Override
	void move() {
		System.out.println("하늘로 다닌다.");
	}
}

class VehicleUse{
	void showMoveStyle(Vehicle vehicle){
		//모든 운송수단을 다 받을 수 있다.
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
