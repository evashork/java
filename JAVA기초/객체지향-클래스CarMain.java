/*
 *  CarŬ������ �̿��Ѵ�.
 */
public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		// car() : ������ - Ŭ���� ��ü�� ������ �� ȣ��Ǵ� ����
		
		System.out.println("car1.name = " + car1.name);
		car1.name = "�ҳ�Ÿ";
		System.out.println("car1.name = \"�ҳ�Ÿ\"");
		System.out.println("car1.name = " + car1.name);
		
		System.out.println("car1.velocity = " + car1.velocity);
		car1.upSpeed();
		System.out.println("car1.upSpeed()");
		System.out.println("car1.velocity = " + car1.velocity);

	
		System.out.println("car1.velocity = " + car1.velocity);
		car1.downSpeed(10);
		System.out.println("car1.downSpeed()");
		System.out.println("car1.velocity = " + car1.velocity);
		
		Car car2 = new Car();
		System.out.println("car2.velocity = " + car2.velocity);
		
		car2 = car1;
		System.out.println("car2 = car1;");
		System.out.println("car2.velocity = " + car2.velocity);
	}
}
