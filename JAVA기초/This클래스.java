/*
 * this()
 * 자기 자신 클래스의 다른 생성자를 호출
 * 클래스 안에 생성자가 여러개 정의될 때 모든 생성자에서 공통적으로 수행해야하는 작업을
 * 특정 생성자에 정의하고 다른 생성자에서는 해당 생성자를 호출해서 공통 작업을 
 * 수행함으로써 중복 코드를 제거하기 위해서 사용됨.
 * 
 * 
 * 음료수 클래스 정의
 * 1.이름은 지정하지 않으면 물이 기본값
 * 2.가격은 지정하지 않으면 800원이 기준값으로 지정
 * 
 * 규칙
 * 다른 생성자의 첫 실행문으로 와야 함
 */

class Drink{
	String name;
	int price;
	
	public Drink() {
		// TODO Auto-generated constructor stub		
		// name = "물";
		// price = 800;
		
		this("물",800);
	}
	
	public Drink(String name) {
		// TODO Auto-generated constructor stub
		//this.name = name;
		//price = 800;
		
		this(name,800);
	}
	
	public Drink(int price) {
		// TODO Auto-generated constructor stub
		//name = "물";
		//this.price = price;
		this("물",price);
	}
	
	public Drink(String name,int price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		
		//this.(name,price) 는 지원하지 않는다.
	}
}

public class ThisContructTest {
	public static void main(String[] args) {
	}
}
