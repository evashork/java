/*
 *  객체 지향 언어
 *  전제 
 *  1. 특징 지울 수 있는 모든 것은 다 객체 이다.
 *  2. 객체는 특성과 기능으로 표현할 수 있다.
 *  	자동차 - 특성(자동차명,색상,속도) 기능(달린다,멈춘다,속도를 올린다)
 *  
 *  객체를 프로그램적으로 추상화 시킨 것이 클래스
 *  객체 ---> 클래스
 *  특성 ---> 속성(변수,상수)
 *  기능 ---> 메소드
 */
//클래스
public class Car {
	//속성
	String name;
	int velocity;
	String company;
	String color;
	
	//메소드
	/*
	 * 리턴타입 메소드이름(파라미터 - 데이터타입 변수명){
	 * 	명령문;
	 * }
	 * 
	 * 메소드 실행 후 리턴해주는 값이 없으면 리턴 값을 void로 지정한다.
	 */
	
	void run(){
		System.out.println("달린다.");
	}
	
	void stop(){
		System.out.println("멈춘다.");
	}
	
	void upSpeed(){
		velocity += 1;
	}
	
	void upSpeed(int amount){
		velocity += amount;
	}
	
	void downSpeed(){
		velocity -= 1;
	}
	
	void downSpeed(int amount){
		velocity -= amount;
	}
}
