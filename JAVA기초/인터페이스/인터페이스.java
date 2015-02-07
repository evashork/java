/*
 *  인터페이스
 */
interface Interface{
	int c = 1;
	//인터페이스에서 변수를 선언하면 변수 앞에 static final이 자동 지정된다. 즉 상수가 된다.
	
	void aaa();
	//인터페이스에는 일반 메소드를 정의 할 수 없고 오직 추상 메소드만 가능하다. 자동으로 abstract가 붙는다. 
}

class Interface1Impl implements Interface{
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
}
public class InterfaceTest1 {

	public static void main(String[] args) {
		Interface1Impl aa = new Interface1Impl();
	}

}
