/*
 *  오버라이딩
 *  부모클래스에서 정의된 메소드를 자식 클래스에서 재정의 하는 것
 *  접근제한과 리턴 타입이 같아야 한다.
 * 
 *  부모 클래스에 정의 된 변수나 메소드를 자식 클래스에서 재정의하면
 *  부모 클래스에서 재정의된 변수나 메소드는 인식되지 않는다.
 */
class Super{
	int money = 30;
	void parentMethod(){
		System.out.println("parent method");
	}
}

class Sub extends Super{
	String money = "30원";
	@Override  // 컨트롤 스페이스
	void parentMethod() {
		// TODO Auto-generated method stub
		System.out.println("overriding method");
	}
}

public class OverRiding {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.parentMethod();
		sub.money = "90원";
	}
}
